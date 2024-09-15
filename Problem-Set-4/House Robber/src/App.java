public class App {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int prev = nums[0], current = Math.max(nums[0], nums[1]), answer = current;
        for (int i = 2; i < nums.length; i++) {
            answer = Math.max(current, prev + nums[i]);
            prev = current;
            current = answer;
        }
        return answer;
    }
}