package neu.edu.info6205.team.objects;

import java.util.List;

public abstract class AbstractMaze {
	
	public abstract int[] getStartPosition();
	public abstract int getPositionValue(int x, int y);
	public abstract boolean isWall(int x, int y);
	public abstract int getMaxX();
	public abstract int getMaxY();
	public abstract int calcRoute(List<int[]> way);
}
