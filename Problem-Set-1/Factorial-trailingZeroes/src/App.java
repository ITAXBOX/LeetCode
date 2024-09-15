public class App {
    public int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        int counter = 0;
        while (n >= 5) {
            n /= 5;
            counter += n;
        }
        return counter;
    }

    public static void main(String[] args) {
        App pbj1 = new App();
        System.out.println(pbj1.trailingZeroes(10));
    }
}
