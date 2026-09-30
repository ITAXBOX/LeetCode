
import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10)
            return new ArrayList<>();

        int[] map = new int[256];
        map['A'] = 0; // 00 in binary
        map['C'] = 1; // 01 in binary
        map['G'] = 2; // 10 in binary
        map['T'] = 3; // 11 in binary

        Set<String> repeated = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        int bitMask = 0;

        for (int i = 0; i < 10; i++) {
            bitMask = (bitMask << 2) | map[s.charAt(i)];
        }
        seen.add(bitMask);

        int clearMask = 0xFFFFF;

        for (int i = 10; i < s.length(); i++) {
            bitMask = ((bitMask << 2) | map[s.charAt(i)]) & clearMask;

            if (!seen.add(bitMask)) {
                repeated.add(s.substring(i - 9, i + 1));
            }
        }

        return new ArrayList<>(repeated);
    }
}
