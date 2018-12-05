package neu.edu.info6205.team.objects;

public class GeneticAlgorithm extends AbstractGeneticAlgorithm {
	
	private int populationSize;
	private double mutationRate;
	private double crossoverRate;
	private int elitismCount;
	
	protected int tournamentSize;
	
	public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount,
			int tournamentSize) {

		this.populationSize = populationSize;
		this.mutationRate = mutationRate;
		this.crossoverRate = crossoverRate;
		this.elitismCount = elitismCount;
		this.tournamentSize = tournamentSize;
	}

	@Override
	public AbstractPopulation firstPopulation(int chromosomeLength) {
		// Initialize population
		AbstractPopulation population = new Population(this.populationSize, chromosomeLength);
		return population;	
		}

	@Override
	public double calcFitness(AbstractIndividual individual, AbstractMaze maze) {
		// Get individual's chromosome
		int[] chromosome = individual.getChromosome();

		// Get fitness
		Robot robot = new Robot(chromosome, maze, 100);
		robot.run();
		int fitness = maze.calcRoute(robot.getWay());

		// Store fitness
		individual.setFitness(fitness);
		// Store Route in individual
		((Individual) individual).setRoute(robot.getWay());
		
		return fitness;
	}

	@Override
	public void calcPopulation(AbstractPopulation population, AbstractMaze maze) {
		double populationFitness = 0;

		// Loop over population evaluating individuals and suming population
		// fitness
		for (AbstractIndividual individual : population.getIndividuals()) {
			populationFitness += this.calcFitness(individual, maze);
		}

		population.setPopulationFitness(populationFitness);
	}

	@Override
	public boolean endConditionMet(int generationsCount, int maxGenerations) {
		return (generationsCount > maxGenerations);
	}

	@Override
	public AbstractIndividual selectParent(AbstractPopulation population) {
		// Create tournament
		AbstractPopulation tournament = new Population(this.tournamentSize);

		// Add random individuals to the tournament
		population.shuffle();
		for (int i = 0; i < this.tournamentSize; i++) {
			AbstractIndividual tournamentIndividual = population.getIndividual(i);
			tournament.setIndividual(i, tournamentIndividual);
		}

		// Return the best
		return tournament.getFittest(0);
			
	}

	@Override
	public AbstractPopulation crossover(AbstractPopulation population) {
		// Create new population
		AbstractPopulation newPopulation = new Population(population.size());

		// Loop over current population by fitness
		for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
			AbstractIndividual parent1 = population.getFittest(populationIndex);

			// Apply crossover to this individual?
			if (this.crossoverRate > Math.random() && populationIndex >= this.elitismCount) {
				// Initialize offspring
				AbstractIndividual offspring = new Individual(parent1.getChromosomeLength());
				
				// Find second parent
				AbstractIndividual parent2 = this.selectParent(population);

				// Get random swap point
				int swapPoint = (int) (Math.random() * (parent1.getChromosomeLength() + 1));

				// Loop over genome
				for (int geneIndex = 0; geneIndex < parent1.getChromosomeLength(); geneIndex++) {
					// Use half of parent1's genes and half of parent2's genes
					if (geneIndex < swapPoint) {
						offspring.setGene(geneIndex, parent1.getGene(geneIndex));
					} else {
						offspring.setGene(geneIndex, parent2.getGene(geneIndex));
					}
				}

				// Add offspring to new population
				newPopulation.setIndividual(populationIndex, offspring);
			} else {
				// Add individual to new population without applying crossover
				newPopulation.setIndividual(populationIndex, parent1);
			}
		}

		return newPopulation;
	}

	@Override
	public AbstractPopulation mutate(AbstractPopulation population) {
		// Initialize new population
		AbstractPopulation newPopulation = new Population(this.populationSize);

		// Loop over current population by fitness
		for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
			AbstractIndividual individual = population.getFittest(populationIndex);

			// Loop over individual's genes
			for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
				// Skip mutation if this is an elite individual
				if (populationIndex >= this.elitismCount) {
					// Does this gene need mutation?
					if (this.mutationRate > Math.random()) {
						// Get new gene
						int newGene = 1;
						if (individual.getGene(geneIndex) == 1) {
							newGene = 0;
						}
						// Mutate gene
						individual.setGene(geneIndex, newGene);
					}
				}
			}


			// Add individual to population
			newPopulation.setIndividual(populationIndex, individual);
		}

		// Return mutated population
		return newPopulation;
	}
	
}
