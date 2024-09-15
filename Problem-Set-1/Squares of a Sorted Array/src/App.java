import java.util.Arrays;

public class App {
    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1, counter = right;
        int[] answer = new int[nums.length];
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                answer[counter--] = (int) Math.pow(nums[left], 2);
                left++;
            } else {
                answer[counter--] = (int) Math.pow(nums[right], 2);
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
    }
}
