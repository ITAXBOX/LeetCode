import java.util.HashMap;

public class App {
    public static HashMap<Integer, Integer> Path = new HashMap<>();

    public static int ClimbingStairs(int n) {
        if (Path.containsKey(n))
            return Path.get(n);
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        int answer = 0;
        for (int i = 1; i <= 2; i++) {
            int temp = ClimbingStairs(n - i);
            answer += temp;
            Path.put(n - i, temp);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(ClimbingStairs(3));
    }
}