public class Solution {
	int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int closedIsland(int[][] grid) {
		int answer = 0;

		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[i].length - 1; j++)
				if (grid[i][j] == 0 && markIsland(grid, i, j))
					answer++;
		}

		return answer;
	}

	private boolean markIsland(int[][] grid, int i, int j) {
		if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
			if (grid[i][j] == 0)
				return false;
			else
				return true;
		}

		if (grid[i][j] >= 1)
			return true;

		grid[i][j] = 2;

		boolean closed = true;
		for (int[] direction : directions) {
			boolean result = markIsland(grid, i + direction[0], j + direction[1]);
			closed = closed && result;
		}

		return closed;
	}
}
