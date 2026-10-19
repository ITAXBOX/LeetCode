package Arrays.targetIndices;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> targetIndices(int[] nums, int target) {
		List<Integer> answer = new ArrayList<>();
		int lessThanTargetCount = 0, targetCount = 0;

		for (int num : nums) {
			if (num < target)
				lessThanTargetCount++;
			else if (num == target)
				targetCount++;
		}

		for (int i = 0; i < targetCount; i++)
			answer.add(lessThanTargetCount + i);

		return answer;
	}
}