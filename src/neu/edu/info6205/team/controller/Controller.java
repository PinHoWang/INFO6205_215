package neu.edu.info6205.team.controller;

public class Controller {
    public static void demo() {
	public static int maxGenerations = 1000;
    Maze m = new Maze(new int[][] { 
      { 0, 0, 0, 0, 1, 0, 1, 3, 2 }, 
      { 1, 0, 1, 1, 1, 0, 1, 3, 1 },
      { 1, 0, 0, 1, 3, 3, 3, 3, 1 }, 
      { 3, 3, 3, 1, 3, 1, 1, 0, 1 }, 
      { 3, 1, 3, 3, 3, 1, 1, 0, 0 },
      { 3, 3, 1, 1, 1, 1, 0, 1, 1 }, 
      { 1, 3, 0, 1, 3, 3, 3, 3, 3 }, 
      { 0, 3, 1, 1, 3, 1, 0, 1, 3 },
      { 1, 3, 3, 3, 3, 1, 1, 1, 4 } 
                                  });
    GeneticAlgorithm gna = new GeneticAlgorithm(200, 0.05, 0.9, 2, 10);
    Population pop = gna.initPopulation(128);
    gna.evalPopulation(pop, m);
    int generation = 1;

    while (gna.isTerminationConditionMet(generation, maxGenerations) == false) 
    {
      Individual fittest = pop.getFittest(0);
      System.out.println("G" + generation + " Best solution (" + fittest.getFitness() + "): " + fittest.toString());
      pop = gna.crossoverPopulation(pop);
      pop = gna.mutatePopulation(pop);
      gna.evalPopulation(pop, m);
      generation++;
    }

    System.out.println("Stopped after " + maxGenerations + " generations.");
    Individual fittest = pop.getFittest(0);
    System.out.println("Best solution (" + fittest.getFitness() + "): " + fittest.toString());

		
    }
}
