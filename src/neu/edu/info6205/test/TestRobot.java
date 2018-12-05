package neu.edu.info6205.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import neu.edu.info6205.team.objects.AbstractMaze;
import neu.edu.info6205.team.objects.Maze;
import neu.edu.info6205.team.objects.Robot;

class TestRobot {
	private static final int[] move = new int[] {1,0,1,0,0,1,1,0,0,1,0,1,0,1};
	
	private static AbstractMaze genMaze() {
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
		
		return m;
	}
	
	private static Robot genRobot() {
		Robot r = new Robot(move, genMaze(), 100);
		return r;
	}
	
	@Test
	void testStartPosition() {
		Robot r = genRobot();
		assertEquals(0, r.getPosition()[0]);
		assertEquals(8, r.getPosition()[1]);
	}

//	@Test
	void testSensorValue() {
		Robot r = genRobot();
	}
}
