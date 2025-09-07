package Math.sumZero;
import java.util.ArrayList;

class Solution {
	public int[] sumZero(int n) {
		int i = 1;
		ArrayList<Integer> answer = new ArrayList<>();

		if (n % 2 == 1) {
			answer.add(0);
			n--;
		}
		while (n != 0) {
			answer.add(i);
			answer.add(-i);
			n -= 2;
			i++;
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
