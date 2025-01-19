import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class App {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                HashSet<Integer> set = map.containsKey(routes[i][j]) ? map.get(routes[i][j]) : new HashSet<>();
                set.add(i);
                map.put(routes[i][j], set);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        int count = 0;
        HashSet<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                HashSet<Integer> buses = map.get(queue.poll());
                if (buses != null) {
                    for (Integer bus : buses) {
                        if (seen.add(bus)) {
                            for (Integer stop : routes[bus]) {
                                if (stop == target)
                                    return count;
                                queue.add(stop);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
