import java.util.*;

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class App {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> answer = new ArrayList<>();
        if (n == 1) {
            return Collections.singletonList(0);
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int target = edges[i][1];
            map.putIfAbsent(source, new HashSet<>());
            map.putIfAbsent(target, new HashSet<>());
            map.get(source).add(target);
            map.get(target).add(source);
        }
        int min = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            int tempMin = Height(key, edges, map);
            if (tempMin == min)
                answer.add(key);
            else if (tempMin < min) {
                answer.clear();
                answer.add(key);
                min = tempMin;
            }
        }
        return answer;
    }

    private static int Height(int key, int[][] edges, HashMap<Integer, HashSet<Integer>> map) {
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        set.add(key);
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();

        for (int i : map.get(key)) {
            queue.offer(new Pair<>(i, 1));
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            set.add(pair.getKey());
            if (pair.getValue() > max)
                max = pair.getValue();
            for (int i : map.get(pair.getKey())) {
                if (set.add(i))
                    queue.offer(new Pair<>(i, pair.getValue() + 1));
            }
        }
        return max;
    }

    public List<Integer> findMinHeightTreesBETEERRRR(int n, int[][] edges) {// this way better using n removing the
                                                                            // leafs to rech the center of the tree
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }

        result.addAll(leaves);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(11, new int[][] { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } }));
        // this method dont use n

    }
}
