public class App {
    public int addDigits(int num) {
        while (num >= 10) {
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }

    public int addDigitsBetter(int num) {
        if (num == 0) {
            return 0;
        }

        return 1 + (num - 1) % 9;
    }
}
