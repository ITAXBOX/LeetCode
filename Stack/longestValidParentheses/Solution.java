package Stack.longestValidParentheses;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int longestValidParentheses(String s) {
		int answer = 0;
		Deque<Integer> deque = new ArrayDeque<>();

		deque.push(-1);

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				deque.push(i);
			} else {
				deque.pop();
				if (deque.isEmpty())
					deque.push(i);
				else
					answer = Math.max(answer, i - deque.peek());
			}
		}

		return answer;
	}
}