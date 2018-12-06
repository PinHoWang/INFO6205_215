package neu.edu.info6205.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import neu.edu.info6205.team.objects.AbstractMaze;
import neu.edu.info6205.team.objects.Maze;

class TestMaze {

	
	private AbstractMaze genMaze() {
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
	
	@Test
	void testStartPosition() {
		AbstractMaze maze = genMaze();
		assertEquals(8, maze.getStartPosition()[0]);
		assertEquals(0, maze.getStartPosition()[1]);
	}
	
	@Test
	void testWay() {
		AbstractMaze maze = genMaze();
		assertEquals(true, maze.isWall(0, 6));
		assertEquals(8, maze.getMaxX());
		assertEquals(8, maze.getMaxY());
	}
}
