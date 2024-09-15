import java.util.HashMap;

public class App {
    public int Fubinacci(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return Fubinacci(n, map);
    }

    private int Fubinacci(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n))
            return map.get(n);
        if (n <= 1)
            return n;
        map.put(n, Fubinacci(n - 1, map) + Fubinacci(n - 2, map));
        return map.get(n);
    }
}
