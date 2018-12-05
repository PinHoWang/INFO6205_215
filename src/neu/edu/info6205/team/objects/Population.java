package chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class Population extends AbstractPopulation{
	private Individual population[];
	private double populationFitness = -1;


	public Population(int populationSize) {
		// Initial population
		this.population = new Individual[populationSize];
	}

	
	public Population(int populationSize, int chromosomeLength) {
		// Initialize the population as an array of individuals
		this.population = new Individual[populationSize];

		// Create each individual in turn
		for (int individualCount = 0; individualCount < populationSize; individualCount++) {
			// Create an individual, initializing its chromosome to the given
			// length
			Individual individual = new Individual(chromosomeLength);
			// Add individual to population
			this.population[individualCount] = individual;
		}
	}

	public AbstractIndividual[] getIndividuals() {
		return this.population;
	}

	public Individual getFittest(int offset) {
		// Order population by fitness
		Arrays.sort(this.population, new Comparator<Individual>() {
			@Override
			public int compare(Individual o1, Individual o2) {
				if (o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});

		// Return the fittest individual
		return this.population[offset];
	}

	/**
	 * Set population's group fitness
	 * 
	 * @param fitness
	 *            The population's total fitness
	 */
	public void setPopulationFitness(double fitness) {
		this.populationFitness = fitness;
	}

	public double getPopulationFitness() {
		return this.populationFitness;
	}

	public int size() {
		return this.population.length;
	}

	public AbstractIndividual setIndividual(int offset, Individual individual) {
		return population[offset] = individual;
	}

	public AbstractIndividual getIndividual(int offset) {
		return population[offset];
	}
	
	public void shuffle() {
		Random rnd = new Random();
		for (int i = population.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Individual a = population[index];
			population[index] = population[i];
			population[i] = a;
		}
	}

	@Override
	public AbstractIndividual setIndividual(int i, AbstractIndividual individual) {
		return null;
	}





}