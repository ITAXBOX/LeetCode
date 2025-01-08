public class App {
    // SLOWWWW
    public static int mySqrt(int x) {
        for (int i = 1; i <= x; i++) {
            if (i * i == x)
                return i;
            if (i * i > x)
                return i - 1;
        }
        return 1;
    }

    // PRIMEEE
    public static int mySqrtPrime(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1, right = x / 2, result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (mid <= x / mid) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(mySqrt(50));
    }
}
