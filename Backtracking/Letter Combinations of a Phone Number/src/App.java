import java.util.ArrayList;
import java.util.List;

class Solution {
    private final String[] two = new String[] { "a", "b", "c" };
    private final String[] three = new String[] { "d", "e", "f" };
    private final String[] four = new String[] { "g", "h", "i" };
    private final String[] five = new String[] { "j", "k", "l" };
    private final String[] six = new String[] { "m", "n", "o" };
    private final String[] seven = new String[] { "p", "q", "r", "s" };
    private final String[] eight = new String[] { "t", "u", "v" };
    private final String[] nine = new String[] { "w", "x", "y", "z" };

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        if (digits.equals(""))
            return answer;

        backtracking(answer, new StringBuilder(), digits, 0);

        return answer;
    }

    private void backtracking(List<String> answer, StringBuilder temp, String digits, int i) {
        if (i == digits.length() + 1) {
            answer.add(temp.toString());
        } else {
            String[] arr = letters(digits.charAt(i));

            for (int j = 0; j < arr.length; j++) {
                temp.append(arr[j]);
                backtracking(answer, temp, digits, i + 1);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    private String[] letters(char num) {
        switch (num) {
            case '2':
                return two;
            case '3':
                return three;
            case '4':
                return four;
            case '5':
                return five;
            case '6':
                return six;
            case '7':
                return seven;
            case '8':
                return eight;
            default:
                return nine;
        }
    }
}