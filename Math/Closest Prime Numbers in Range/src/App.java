import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] primes = primes(left, right);

        if (primes.length <= 1)
            return new int[] { -1, -1 };

        int num1 = 0, num2 = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < primes.length; i++) {
            if (primes[i] - primes[i - 1] < min) {
                min = primes[i] - primes[i - 1];
                num2 = primes[i - 1];
                num1 = primes[i];
            }
        }

        return new int[] { num1, num2 };
    }

    public static int[] primes(int left, int right) {
        if (right < 2) {
            return new int[0];
        }

        left = Math.max(left, 2);

        boolean[] isPrime = new boolean[right + 1];
        for (int i = 2; i <= right; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }

        int[] result = new int[primeList.size()];
        for (int i = 0; i < primeList.size(); i++) {
            result[i] = primeList.get(i);
        }

        return result;
    }
}