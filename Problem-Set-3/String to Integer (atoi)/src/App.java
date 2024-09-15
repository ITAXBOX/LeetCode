public class App {
    public int myAtoi(String s) {
        boolean negative = false;
        int answer = 0, i = 0;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        if (s.charAt(0) == '-') {
            negative = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            int digit = c - '0';
            if (answer > Integer.MAX_VALUE / 10 ||
                    (answer == Integer.MAX_VALUE / 10 && digit > 7)) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            answer = answer * 10 + digit;
        }

        return negative ? -answer : answer;
    }

}