public class App {
    private final int MOD = 1000000007;
    private int[][][] dp;

    public int checkRecord(int n) {
        dp = new int[n + 1][2][3];
        return checkRecord(n, 0, 0);
    }

    private int checkRecord(int n, int A, int L) {
        if (n == 0)
            return 1;
        if (dp[n][A][L] != 0)
            return dp[n][A][L];
        int answer = 0;
        answer = (answer + checkRecord(n - 1, A, 0)) % MOD;
        if (A < 1) {
            answer = (answer + checkRecord(n - 1, A + 1, 0)) % MOD;
        }
        if (L < 2)
            answer = (answer + checkRecord(n - 1, A, L + 1)) % MOD;
        dp[n][A][L] = answer;
        return answer;
    }
}