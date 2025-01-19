import java.util.Arrays;

public class App {
    public int minimumSum(int num) {
        int[] nums = new int[4];
        int i = 0;
        while (num > 0) {
            nums[i++] = num % 10;
            num = num / 10;
        }
        Arrays.sort(nums);
        return nums[0] * 10 + nums[3] + nums[1] * 10 + nums[2];
    }
}