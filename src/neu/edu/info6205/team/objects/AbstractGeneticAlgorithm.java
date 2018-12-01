package neu.edu.info6205.team.objects;

public abstract class AbstractGeneticAlgorithm {
	private int populationSize;
	private double mutationRate;
	private double crossoverRate;
	private int elitismCount;
	
	public abstract AbstractPopulation initPopulation(int chromosomeLength);
	public abstract double calcFitness(AbstractIndividual individual);
	public abstract void evalPopulation(AbstractPopulation population);
	public abstract boolean isTerminationConditionMet(AbstractPopulation population);
	public abstract AbstractIndividual selectParent(AbstractPopulation population);
	public abstract AbstractPopulation crossoverPopulation(AbstractPopulation population);
	public abstract AbstractPopulation mutatePopulation(AbstractPopulation population);
	
}
