import java.util.*;

public class project2 {
    public static void main(String[] args) throws Exception {
        SingleLinkedListDeque<Integer> deque = new SingleLinkedListDeque<>();
        deque.addAll(Arrays.asList(1, 2, 3, 4));
        System.out.println(deque);
        deque.removeLastOccurrence(1);
        System.out.println(deque);
    }
}
