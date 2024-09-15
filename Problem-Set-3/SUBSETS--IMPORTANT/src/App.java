import java.util.*;

public class App {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            result.add(new ArrayList<>(current));
            generateSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
