package neu.edu.info6205.team.objects;


public abstract class AbstractIndividual {
	private int[] chromosome;
	private double fitness;

	public int[] getChromosome();
	public int getChromosomeLength();
	public void setGene(int i, int gene);
	public int getGene(int i);
	public void setFitness(double fitness);
	public double getFitness();

}