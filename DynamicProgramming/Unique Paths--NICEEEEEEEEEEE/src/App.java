public class App {
    int[][] paths = new int[100][100];//Memoization

    public int uniquePaths(int m, int n) {
        return Paths(0, 0, m, n);
    }

    private int Paths(int i, int j, int m, int n) {
        if (i >= m || j >= n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        if (paths[i][j] == 0)
            paths[i][j] = Paths(i + 1, j, m, n) + Paths(i, j + 1, m, n);
        return paths[i][j];
    }

    public int uniquePaths_Tabulation(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
