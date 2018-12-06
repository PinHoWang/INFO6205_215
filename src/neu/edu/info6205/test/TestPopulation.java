package neu.edu.info6205.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import neu.edu.info6205.team.objects.AbstractIndividual;
import neu.edu.info6205.team.objects.AbstractPopulation;
import neu.edu.info6205.team.objects.Individual;
import neu.edu.info6205.team.objects.Population;

class TestPopulation {

	@Test
	void testSize() {
		AbstractPopulation p = new Population(200);
		assertEquals(200, p.size());
	}
	
	@Test
	void testIndividual() {
		AbstractIndividual i = new Individual(128);
		i.setGene(60, 1);
		AbstractPopulation p = new Population(200);
		p.setIndividual(50, i);
		assertEquals(1, p.getIndividual(50).getGene(60));
	}

}
