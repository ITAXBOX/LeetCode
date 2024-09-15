public class App {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return Ways(nums, target, n - 1);
    }
    public int Ways(int[] nums, int target, int index) {
        if (index == 0) {
            int ways = 0;
            if ((target - nums[index] == 0))
                ways++;
            if (target + nums[index] == 0)
                ways++;

            return ways;
        }
        int addition = Ways(nums, target + nums[index], index - 1);
        int subtraction = Ways(nums, target - nums[index], index - 1);

        return addition + subtraction;
    }
}
