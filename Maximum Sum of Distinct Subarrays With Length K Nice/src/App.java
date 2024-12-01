import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long answer = 0, temp = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> numbersCausingProblems = new HashSet<>();

        for (int i = 0; i < k; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
            temp += nums[i];
            if (count > 1) {
                numbersCausingProblems.add(nums[i]);
            }
        }

        if (numbersCausingProblems.isEmpty()) {
            answer = temp;
        }

        for (int i = 1; i <= n - k; i++) {
            int left = nums[i - 1];
            int leftCount = map.get(left) - 1;
            map.put(left, leftCount);
            if (leftCount == 1) {
                numbersCausingProblems.remove(left);
            } else if (leftCount == 0) {
                map.remove(left);
            }

            int right = nums[i + k - 1];
            int rightCount = map.getOrDefault(right, 0) + 1;
            map.put(right, rightCount);
            if (rightCount > 1) {
                numbersCausingProblems.add(right);
            }

            temp = temp - left + right;

            if (numbersCausingProblems.isEmpty()) {
                answer = Math.max(answer, temp);
            }
        }

        return answer;
    }
}
