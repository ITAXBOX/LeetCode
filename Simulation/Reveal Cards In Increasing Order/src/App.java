import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class App {
    // Input: deck = [17,13,11,2,3,5,7] [2,3,5,7,11,13,17]
    // Output: [2,13,3,11,5,17,7]
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Deque<Integer> indices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indices.offer(i);
        }
        int[] answer = new int[n];
        for (int card : deck) {
            answer[indices.poll()] = card;
            if (!indices.isEmpty()) {
                indices.offer(indices.poll());
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[] { 17, 13, 11, 2, 3, 5, 7 })));
    }
}