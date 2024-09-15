public class App {
    public static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculateGCD(b, a % b);
        }
    }

    public static int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }

    public static void main(String[] args) {
        int num1 = 24;
        int num2 = 36;

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + calculateGCD(num1, num2));
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + calculateLCM(num1, num2));
    }
}
