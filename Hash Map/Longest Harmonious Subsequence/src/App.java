import java.util.HashMap;

public class App {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.containsKey(nums[i] - 1)) {
                answer = Math.max(answer, map.get(nums[i]) + map.get(nums[i] - 1));
            }

            if (map.containsKey(nums[i] + 1)) {
                answer = Math.max(answer, map.get(nums[i]) + map.get(nums[i] + 1));
            }
        }
        return answer;
    }
}
