package neu.edu.info6205.team.objects;

public abstract class AbstractGeneticAlgorithm {
	
	public abstract AbstractPopulation firstPopulation(int chromosomeLength);
	public abstract double calcFitness(AbstractIndividual individual, AbstractMaze maze);
	public abstract void calcPopulation(AbstractPopulation population, AbstractMaze maze);
	public abstract boolean endConditionMet(int x, int y);
	public abstract AbstractIndividual selectParent(AbstractPopulation population);
	public abstract AbstractPopulation crossover(AbstractPopulation population);
	public abstract AbstractPopulation mutate(AbstractPopulation population);
	
}
