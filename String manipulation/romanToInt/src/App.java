import java.util.HashMap;

public class App {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, prev = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = map.get(currentChar);

            if (currentValue < prev) {
                ans -= currentValue;
            } else {
                ans += currentValue;
            }

            prev = currentValue;
        }

        return ans;
    }

    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();

        int n = num;

        while (n >= 1000) {
            ans.append("M");
            n -= 1000;
        }
        while (n >= 900) {
            ans.append("CM");
            n -= 900;
        }
        while (n >= 500) {
            ans.append("D");
            n -= 500;
        }
        while (n >= 400) {
            ans.append("CD");
            n -= 400;
        }
        while (n >= 100) {
            ans.append("C");
            n -= 100;
        }
        while (n >= 90) {
            ans.append("XC");
            n -= 90;
        }
        while (n >= 50) {
            ans.append("L");
            n -= 50;
        }
        while (n >= 40) {
            ans.append("XL");
            n -= 40;
        }
        while (n >= 10) {
            ans.append("X");
            n -= 10;
        }
        while (n >= 9) {
            ans.append("IX");
            n -= 9;
        }
        while (n >= 5) {
            ans.append("V");
            n -= 5;
        }
        while (n >= 4) {
            ans.append("IV");
            n -= 4;
        }
        while (n > 0) {
            ans.append("I");
            n -= 1;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
