import java.util.Arrays;

public class Test {
	private static boolean reachTarget(int[] nums, int sum, int target, int start) {
		if (target == sum)
			return true;

		if (sum < target)
			return false;

		for (int i = start; i < nums.length; i++)
			if (reachTarget(nums, sum - nums[i], target, i + 1))
				return true;

		return false;
	}

	public static int maxSumDivThree(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		int target = sum;

		if (target % 3 == 0)
			return target;

		while (target != 0) {
			while (target % 3 != 0)
				target--;

			if (target == 0 || reachTarget(nums, sum, target, 0))
				break;

			target--;
		}

		return target;
	}

	public static void main(String[] args) {
		System.out.println(maxSumDivThree(new int[] { 1, 2, 3, 4, 4 }));
	}
}