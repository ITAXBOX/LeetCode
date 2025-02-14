public class App {
    // SLOWWWW
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double ans = x;
        for (int i = 1; i < Math.abs(n); i++) {
            ans *= ans;
        }
        if (n < 0)
            return 1 / ans;
        return ans;
    }

    // PRIMEE
    public double myPowPrime(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = myPowPrime(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return n < 0 ? (1 / x) * half * half : x * half * half;
        }
    }
}
