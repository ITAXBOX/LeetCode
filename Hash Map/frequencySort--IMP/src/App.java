import java.util.*;

public class App {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        Integer[] newNums = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
            newNums[i] = nums[i];
        }

        Arrays.sort(newNums, (n1, n2) -> {
            if (frequency.get(n1) != frequency.get(n2)) {
                return frequency.get(n1) - frequency.get(n2);
            } else {
                return n2 - n1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }

        return nums;
    }
}
