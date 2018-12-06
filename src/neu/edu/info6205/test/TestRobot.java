package neu.edu.info6205.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import neu.edu.info6205.helper.MazeGenerator;
import neu.edu.info6205.team.objects.Robot;

class TestRobot {
	private static final int[] move = new int[] {1,0,1,0,0,1,1,0,0,1,0,1,0,1};
	
	private static Robot genRobot() {
		Robot r = new Robot(move, MazeGenerator.readMaze("Maze1"), 100);
		return r;
	}
	
	@Test
	void testStartPosition() {
		Robot r = genRobot();
		assertEquals(8, r.getPosition()[0]);
		assertEquals(0, r.getPosition()[1]);
	}

	@Test
	void testHeading() {
		Robot r = genRobot();
		assertEquals(31, r.getSensorValue());
	}
}
