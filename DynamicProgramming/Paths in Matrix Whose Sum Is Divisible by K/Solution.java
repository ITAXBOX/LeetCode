class BetterSolution {
	private static final int MOD = 1_000_000_007;

	public int numberOfPaths(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		Integer[][][] tab = new Integer[m][n][k];

		return dfs(grid, k, 0, 0, 0, tab);
	}

	private int dfs(int[][] grid, int k, int i, int j, int sum, Integer[][][] tab) {
		if (i == grid.length || j == grid[0].length)
			return 0;

		sum = (sum + grid[i][j]) % k;

		if (i == grid.length - 1 && j == grid[0].length - 1)
			return sum == 0 ? 1 : 0;

		if (tab[i][j][sum] != null)
			return tab[i][j][sum];

		long ways = 0;
		ways += dfs(grid, k, i, j + 1, sum, tab);
		ways += dfs(grid, k, i + 1, j, sum, tab);

		return tab[i][j][sum] = (int) (ways % MOD);
	}
}

class Solution {
	private static final long MODULO = 1000000007;

	private int dfs(int[][] grid, int k, int i, int j, long sum) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
			return 0;

		sum += grid[i][j];

		if (i == grid.length - 1 && j == grid[0].length - 1)
			return sum % k == 0 ? 1 : 0;

		int result = dfs(grid, k, i, j + 1, sum) + dfs(grid, k, i + 1, j, sum);

		return (int) (result % MODULO);
	}

	public int numberOfPaths(int[][] grid, int k) {
		return dfs(grid, k, 0, 0, 0);
	}
}