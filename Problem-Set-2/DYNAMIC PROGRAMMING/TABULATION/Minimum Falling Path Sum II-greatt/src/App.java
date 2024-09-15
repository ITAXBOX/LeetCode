public class App {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        // Initialize dp with the first row of grid
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        // Calculate minimum sum for each subsequent row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minPrev = Integer.MAX_VALUE;
                // Find the minimum of previous row excluding current column
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        minPrev = Math.min(minPrev, dp[i - 1][k]);
                    }
                }
                dp[i][j] = grid[i][j] + minPrev;
            }
        }

        // Find the minimum sum in the last row
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }

        return minSum;
    }

}