package neu.edu.info6205.team.objects;

public abstract class AbstractPopulation {
	public abstract AbstractIndividual[] getIndividuals();
	public abstract AbstractIndividual getFittest(int i);
	public abstract void setPopulationFitness(double fitness);
	public abstract double getPopulationFitness();
	public abstract int size();
	public abstract AbstractIndividual setIndividual(int i, AbstractIndividual individual);
	public abstract AbstractIndividual getIndividual(int i);
	public abstract void shuffle();
}
