package neu.edu.info6205.team.controller;

import java.util.List;

import neu.edu.info6205.team.objects.AbstractIndividual;
import neu.edu.info6205.team.objects.AbstractMaze;
import neu.edu.info6205.team.objects.AbstractPopulation;
import neu.edu.info6205.team.objects.GeneticAlgorithm;
import neu.edu.info6205.team.objects.Individual;
import neu.edu.info6205.team.objects.Maze;

public class Controller {
	
	public static int maxGenerations = 1000;
	
	public static void demo() {
		AbstractMaze m = new Maze(new int[][] { 
			{ 0, 0, 0, 0, 1, 0, 1, 3, 2 }, 
			{ 1, 0, 1, 1, 1, 0, 1, 3, 1 },
			{ 1, 0, 0, 1, 3, 3, 3, 3, 1 }, 
			{ 3, 3, 3, 1, 3, 1, 1, 0, 1 }, 
			{ 3, 1, 3, 3, 3, 1, 1, 0, 0 },
			{ 3, 3, 1, 1, 1, 1, 0, 1, 1 }, 
			{ 1, 3, 0, 1, 3, 3, 3, 3, 3 }, 
			{ 0, 3, 1, 1, 3, 1, 0, 1, 3 },
			{ 1, 3, 3, 3, 3, 1, 1, 1, 4 } });
		
		GeneticAlgorithm gna = new GeneticAlgorithm(200, 0.05, 0.9, 2, 10);
		AbstractPopulation pop = gna.firstPopulation(128);
		gna.calcPopulation(pop, m);
		int generation = 1;

		while (gna.endConditionMet(generation, maxGenerations) == false) 
		{
			AbstractIndividual fittest = pop.getFittest(0);
			System.out.println("G" + generation + " Best solution (" + fittest.getFitness() + "): " + fittest.toString());
			pop = gna.crossover(pop);
			pop = gna.mutate(pop);
			gna.calcPopulation(pop, m);
			generation++;
		}

		System.out.println("Stopped after " + maxGenerations + " generations.");
		AbstractIndividual fittest = pop.getFittest(0);
		System.out.println("Best solution (" + fittest.getFitness() + "): " + fittest.toString());
		
		/*
		 * Create a ArrayList<int[]> to record the route of each individual
		 * so that we can get the route from the fittest individual
		 */
		List<int[]> r = ((Individual) fittest).getRoute();
		printFittestRoute(r, m.getMaxX(), m.getMaxY());
    }
	
	private static void printFittestRoute(List<int[]> r, int maxX, int maxY) {
		int[][] way = new int[maxX+1][maxY+1];
		for(int[] pair : r) {
			way[pair[0]][pair[1]] = 1;
			System.out.println(pair[0] + " " + pair[1]);
		}
		
		for(int i = 0; i < way.length; i++) {
			for(int j = 0; j < way[i].length; j++) {
				System.out.print(way[j][i] + " ");
			}
			System.out.println();
		}
	}
}