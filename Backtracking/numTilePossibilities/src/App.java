import java.util.HashMap;

class Solution {
    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return backtrack(map);
    }

    private int backtrack(HashMap<Character, Integer> map) {
        int count = 0;
        for (char c : map.keySet()) {
            if (map.get(c) > 0) {
                count++;
                map.put(c, map.get(c) - 1);
                count += backtrack(map);
                map.put(c, map.get(c) + 1);
            }
        }
        return count;
    }
}