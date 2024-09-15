public class App {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int result = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i < k) {
                result += Integer.min(tickets[i], tickets[k]);
            } else if (i > k) {
                result += Integer.min(tickets[i], tickets[k] - 1);
            } else {
                result += tickets[i];
            }
        }
        return result;
    }
}
