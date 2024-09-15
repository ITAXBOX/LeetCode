import java.util.Arrays;

public class App {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int maxWidth = 0;

        Arrays.sort(points, (p1, p2) -> (p1[0] - p2[0]));

        for (int i = 0; i < points.length - 1; i++) {
            int[] point1 = points[i], point2 = points[i + 1];
            maxWidth = Math.max(maxWidth, point2[0] - point1[0]);
        }
        
        return maxWidth;
    }
    
}