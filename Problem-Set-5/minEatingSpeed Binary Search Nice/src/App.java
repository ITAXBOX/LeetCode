import java.util.Arrays;

public class App {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int answer = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;

            for (int pile : piles) {
                hours += Math.ceil((double) pile / mid);
            }

            if (hours <= h) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
