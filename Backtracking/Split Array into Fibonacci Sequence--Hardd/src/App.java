import java.util.*;

class Solution {
    // Input: num = "1101111"
    // Output: [11,0,11,11]
    // Explanation: The output [110, 1, 111] would also be accepted.
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> list = new ArrayList<>();
        dfs(num.toCharArray(), list, 0);
        return list;
    }

    public boolean dfs(char[] digit, List<Integer> list, int index) {
        if (index == digit.length && list.size() >= 3) {
            return true;
        }
        for (int i = index; i < digit.length; i++) {
            if (digit[index] == '0' && i > index) {
                break;
            }
            long num = subDigit(digit, index, i + 1);
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = list.size();
            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == list.get(size - 1) + list.get(size - 2)) {
                list.add((int) num);
                if (dfs(digit, list, i + 1))
                    return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    private long subDigit(char[] digit, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digit[i] - '0';
        }
        return res;
    }
}
