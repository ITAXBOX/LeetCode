public class App {
    public int minOperations(int[] nums) {
        int answer = 0;

        for (int i = 1; i < nums.length; i++)
            if (nums[i] <= nums[i - 1]) {
                int target = nums[i - 1] + 1;
                answer += target - nums[i];
                nums[i] = target;
            }

        return answer;
    }
}
