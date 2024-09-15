import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class App {
    public boolean t(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0)
            return false;
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination)
                return true;
            if (visited.contains(current))
                continue;
            visited.add(current);
            if (map.containsKey(current)) {
                for (int neighbor : map.get(current)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return false;
    }

}
