import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }

        for (int i = 0; i < n; i++) {
            int end = map.get(s.charAt(i));
            int counter = 0;
            while (end >= i) {
                end = Math.max(end, map.get(s.charAt(i)));
                counter++;
                i++;
            }
            answer.add(counter);
            i--;
        }

        return answer;
    }
}