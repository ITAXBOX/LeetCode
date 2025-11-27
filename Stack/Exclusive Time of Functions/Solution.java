import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result = new int[n];
		Deque<Integer> stack = new ArrayDeque<>();
		int prev = 0;

		for (String log : logs) {
			String[] arr = log.split(":");
			int id = Integer.parseInt(arr[0]);
			String type = arr[1];
			int time = Integer.parseInt(arr[2]);

			if (type.charAt(0) == 's') {
				if (!stack.isEmpty())
					result[stack.peek()] += time - prev;
				stack.push(id);
				prev = time;
			} else {
				result[stack.pop()] += time - prev + 1;
				prev = time + 1;
			}
		}

		return result;
	}
}