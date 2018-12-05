package neu.edu.info6205.team.controller;

public class Controller {
 public static int maxGenerations = 1000;
  public static void demo() {
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
    Population pop = gna.firstPopulation(128);
    gna.calcPopulation(pop, m);
    int generation = 1;

    while (gna.endConditionMet(generation, maxGenerations) == false) 
    {
      Individual fittest = pop.getFittest(0);
      System.out.println("G" + generation + " Best solution (" + fittest.getFitness() + "): " + fittest.toString());
      pop = gna.crossover(pop);
      pop = gna.mutate(pop);
      gna.calcPopulation(pop, m);
      generation++;
    }

    System.out.println("Stopped after " + maxGenerations + " generations.");
    Individual fittest = pop.getFittest(0);
    System.out.println("Best solution (" + fittest.getFitness() + "): " + fittest.toString());

    
    }
}
