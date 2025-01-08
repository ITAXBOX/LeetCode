import java.util.*;

public class App {
    public static int LongestSubstring(String given) {
        int begin = 0, answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < given.length(); i++) {
            if (map.containsKey(given.charAt(i)) && map.get(given.charAt(i)) >= begin) {
                begin = map.get(given.charAt(i)) + 1;
            }
            map.put(given.charAt(i), i);
            answer = Math.max(answer, i - begin + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubstring("abczbaapoiuy"));
    }
}
