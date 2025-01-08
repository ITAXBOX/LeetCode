public class App {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Create a DP table to store the minimum falling path sum
        int[][] dp = new int[n][n];

        // Copy the first row from the matrix to the DP table
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Iterate over each row and each column to fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize the minimum falling path sum for the current position
                int minSum = dp[i - 1][j];

                // Check the three possible positions in the previous row
                if (j > 0) {
                    minSum = Math.min(minSum, dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    minSum = Math.min(minSum, dp[i - 1][j + 1]);
                }

                // Update the DP table with the minimum falling path sum for the current
                // position
                dp[i][j] = matrix[i][j] + minSum;
            }
        }

        // Find the minimum falling path sum in the last row of the DP table
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][j]);
        }

        return minPathSum;
    }
}
