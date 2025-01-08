import java.util.Arrays;

public class App {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 1) {
            digits = Arrays.copyOf(digits, digits.length + 1);
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new App().plusOne(new int[] { 9, 9, 9 })));// 1000
    }
}
