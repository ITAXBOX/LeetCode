import java.util.*;

public class App {
    // [3,2,1,5,6,4], k = 2
    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            maxHeap.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
    }
}
