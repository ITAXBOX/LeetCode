package Graph.countIslands;
public class Solution {
	public int countIslands(int[][] grid, int k) {
		int answer = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] <= 0)
					continue;
				long sum = islandSum(grid, i, j);

				if (sum % k == 0)
					answer++;
			}
		}

		return answer;
	}

	private long islandSum(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] <= 0)
			return 0;

		int temp = grid[i][j];
		grid[i][j] = -1;

		return temp + islandSum(grid, i + 1, j) + islandSum(grid, i - 1, j) + islandSum(grid, i, j + 1) + islandSum(grid, i, j - 1);
	}
}