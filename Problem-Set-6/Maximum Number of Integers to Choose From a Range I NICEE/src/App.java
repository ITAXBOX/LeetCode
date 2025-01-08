import java.util.HashSet;

class Solution {
    private int answer = 0;

    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : banned) {
            set.add(i);
        }

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            sum += i;
            if (sum > maxSum) {
                break;
            }
            answer++;
        }

        return answer;
    }
}