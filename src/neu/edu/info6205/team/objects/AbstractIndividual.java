package neu.edu.info6205.team.objects;

public abstract class AbstractIndividual {
	private int[] chromosome;
	private double fitness;

	public abstract int[] getChromosome();
	public abstract int getChromosomeLength();
	public abstract void setGene(int i, int gene);
	public abstract int getGene(int i);
	public abstract void setFitness(double fitness);
	public abstract double getFitness();
}
