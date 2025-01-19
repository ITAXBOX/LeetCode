import java.util.HashMap;

public class App {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c, 1);
            }
        }

        int ans = 0;
        boolean isFirstOdd = false;

        for (Character key : hm.keySet()) {
            ans += hm.get(key);
            if (hm.get(key) % 2 != 0) {
                if (!isFirstOdd) {
                    isFirstOdd = true;
                } else {
                    ans -= 1;
                }
            }
        }

        return ans;
    }

    public int longestPalindrome_Prime(String s) {
        int[] arr = new int[100];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            if (arr[i] % 2 == 1) {
                ans += (arr[i] - 1);
            } else {
                ans += arr[i];
            }
        }
        if (ans < s.length()) {
            return ans + 1;
        }
        return ans;
    }
}
