import java.util.ArrayList;
import java.util.List;

public class App {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (i <= n) {
                dfs(i, n, answer);
            } else {
                break;
            }
        }
        return answer;
    }
    
    private void dfs(int curr, int n, List<Integer> answer) {
        if (curr > n) {
            return;
        }
        answer.add(curr);
        for (int i = 0; i <= 9; i++) {
            int next = curr * 10 + i;
            if (next > n) {
                return;
            }
            dfs(next, n, answer);
        }
    }
    
}
