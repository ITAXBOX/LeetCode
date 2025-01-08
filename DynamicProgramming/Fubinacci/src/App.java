public class App {
    public static int Fibonacci(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        return Fibonacci(x - 1) + Fibonacci(x - 2);
    }

    public static int BetterFibonacci(int x) {
        int previousNumber = 0, currentNumber = 1;

        for (int i = 0; i < x; i++) {
            int nextNumber = previousNumber + currentNumber;
            previousNumber = currentNumber;
            currentNumber = nextNumber;
        }
        return previousNumber;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(BetterFibonacci(9));
    }
}
