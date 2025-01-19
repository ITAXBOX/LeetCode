import java.util.ArrayDeque;
import java.util.Deque;

public class App {
    public static String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(ch - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pollLast());
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
    }
}
