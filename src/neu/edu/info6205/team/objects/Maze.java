package neu.edu.info6205.team.objects;

import java.util.List;

public class Maze extends AbstractMaze {

	private final int mapArray[][];
	private int startPosition[] = { Integer.MIN_VALUE, Integer.MIN_VALUE };

	public Maze(int mapArray[][]) {
		this.mapArray = mapArray;
	}
	
	@Override
	public int[] getStartPosition() {
		if (this.startPosition[0] != Integer.MIN_VALUE && this.startPosition[1] != Integer.MIN_VALUE) {
			return this.startPosition;
		}

		int startPosition[] = { 0, 0 };

		// Loop over rows
		for (int i = 0; i < this.mapArray.length; i++) {
			// Loop over columns
			for (int j = 0; j < this.mapArray[i].length; j++) {
				// 2 is the type for start position
				if (this.mapArray[i][j] == 2) {
					this.startPosition = new int[] { j, i };
					return new int[] { j, i };
				}
			}
		}

		return startPosition;
	}
	
	
	@Override
	public int getPositionValue(int x, int y) {
		if (x < 0 || y < 0 || x >= this.mapArray.length || y >= this.mapArray[0].length) {
			return 1;
		}
		return this.mapArray[y][x];
	}
	
	@Override
	public boolean isWall(int x, int y) {
		return (this.getPositionValue(x, y) == 1);
	}
	
	@Override
	public int getMaxX() {
		return this.mapArray[0].length - 1;
	}
	
	@Override
	public int getMaxY() {
		return this.mapArray.length - 1;
	}
	
	@Override
	public int calcRoute(List<int[]> way) {
		int count = 0;
		boolean[][] visited = new boolean[this.getMaxY() + 1][this.getMaxX() + 1];

		// Loop over route and score each move
		for (Object eachStep : way) {
			int step[] = (int[]) eachStep;
			if ((this.mapArray[step[1]][step[0]] == 3 && visited[step[1]][step[0]] == false )||this.mapArray[step[1]][step[0]] == 4) {
				// Increase score for correct move
				count++;
				// Remove reward
				visited[step[1]][step[0]] = true;
			}
//			else if (this.mapArray[step[1]][step[0]] == 0 ||this.mapArray[step[1]][step[0]] == 1) {
//				// Increase score for correct move
//				count--;
//				// Remove reward
//				visited[step[1]][step[0]] = true;
//			}
		}

		return count;
	}
}
