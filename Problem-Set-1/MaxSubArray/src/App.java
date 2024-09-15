public class App {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int current = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }
}