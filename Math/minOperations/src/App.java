import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int answer = 0;
        List<Integer> numbers = new ArrayList<>();

        for (int[] nums : grid) {
            for (int num : nums) {
                numbers.add(num);
            }
        }

        Collections.sort(numbers);

        for (int num : numbers) {
            if ((num - numbers.get(0)) % x != 0) {
                return -1;
            }
        }

        int median = numbers.get(numbers.size() / 2);

        for (int num : numbers) {
            answer += Math.abs(num - median) / x;
        }

        return answer;
    }
}