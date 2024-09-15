import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        search(candidates, target, 0, new ArrayList<>());

        return answer;
    }

    private void search(int[] candidates, int target, int start, List<Integer> current) {
        if (target == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; 
            }

            if (candidates[i] > target) {
                break; 
            }

            current.add(candidates[i]);
            search(candidates, target - candidates[i], i + 1, current);
            current.remove(current.size() - 1);
        }

    }

}