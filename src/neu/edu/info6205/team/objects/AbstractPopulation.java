
package neu.edu.info6205.team.objects;

public abstract class AbstractPopulation {
	private AbstractIndividual population[];
	private double populationFitness;

	public AbstractIndividual[] getIndividuals();
	public AbstractIndividual getFittest(int i);
	public void setPopulationFitness(double fitness);
	public double getPopulationFitness();
	public int size();
	public AbstractIndividual setIndividual(int i, AbstractIndividual individual);
	public AbstractIndividual getIndividual(int i);
	public void shuffle();


}