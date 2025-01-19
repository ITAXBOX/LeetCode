import java.util.ArrayDeque;
import java.util.Deque;

public class App {
    public class ValidParentheses {
        public boolean checkValidString(String s) {
            Deque<Integer> left = new ArrayDeque<>();
            Deque<Integer> star = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    left.push(i);
                } else if (ch == '*') {
                    star.push(i);
                } else {
                    if (!left.isEmpty()) {
                        left.pop();
                    } else if (!star.isEmpty()) {
                        star.pop();
                    } else {
                        return false;
                    }
                }
            }
            while (!left.isEmpty() && !star.isEmpty()) {
                if (left.peek() < star.peek()) {
                    left.pop();
                    star.pop();
                } else {
                    break;
                }
            }
            return left.isEmpty();
        }
    }
}