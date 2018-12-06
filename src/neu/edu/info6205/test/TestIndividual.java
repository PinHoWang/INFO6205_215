package neu.edu.info6205.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import neu.edu.info6205.team.objects.AbstractIndividual;
import neu.edu.info6205.team.objects.Individual;

class TestIndividual {

	@Test
	void testChromosomeSize() {
		AbstractIndividual i = new Individual(128);
		assertEquals(128, i.getChromosomeLength());
	}
	
	@Test
	void testFittest() {
		AbstractIndividual i = new Individual(128);
		i.setFitness(5.0);
		assertEquals(5.0, i.getFitness());
	}
	
	@Test
	void testGene() {
		AbstractIndividual i = new Individual(128);
		i.setGene(50, 1);
		assertEquals(1, i.getGene(50));
	}

}
