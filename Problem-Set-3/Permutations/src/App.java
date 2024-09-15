import java.util.*;

public class App {
    HashSet<ArrayList<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Permutations(0, nums.length - 1, nums, ans);
        return ans;
    }

    private void Permutations(int start, int end, int[] nums, List<List<Integer>> ans) {
        if (start == end) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : nums) {
                temp.add(i);
            }
            if (set.add(temp))
                ans.add(temp);
        } else {
            for (int i = start; i <= end; i++) {
                Swap(start, i, nums);
                Permutations(start + 1, end, nums, ans);
                Swap(start, i, nums);
            }
        }

    }

    private void Swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
