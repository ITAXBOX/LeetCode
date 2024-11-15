import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

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

    public int findMinDifference(List<String> timePoints) {
        TreeSet<LocalTime> sortedSet = new TreeSet<>();

        for (String time : timePoints) {
            LocalTime localTime = LocalTime.parse(time);
            if (!sortedSet.add(localTime)) {
                return 0;
            }
        }

        long minDifference = Long.MAX_VALUE;
        LocalTime firstTime = null, previousTime = null;

        for (LocalTime currentTime : sortedSet) {
            if (previousTime != null) {
                long difference = Duration.between(previousTime, currentTime).toMinutes();
                minDifference = Math.min(minDifference, difference);
            }
            if (firstTime == null) {
                firstTime = currentTime;
            }
            previousTime = currentTime;
        }

        if (firstTime != null && previousTime != null) {
            long wrapAroundDifference = Duration.between(previousTime, firstTime).plusMinutes(24 * 60).toMinutes();
            minDifference = Math.min(minDifference, wrapAroundDifference);
        }

        return (int) minDifference;
    }

    public String shortestPalindrome(String s) {
        String t = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < t.length(); i++) {
            if (s.startsWith(t.substring(i))) {
                return t.substring(0, i) + s;
            }
        }

        return t + s;
    }
}

class Solution implements Comparator<String> {
    public static String largestNumber(int[] nums) {
        String[] stringArray = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.sort(stringArray, new Solution());
        if (stringArray[0].equals("0")) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            ans.append(stringArray[i]);
        }
        return ans.toString();
    }

    public int compare(String a, String b) {
        String order1 = a + b;
        String order2 = b + a;
        return order2.compareTo(order1);
    }
}