public class App {
    public int reverse(int x) {
        long answer = 0;
        while (x != 0) {
            answer = answer * 10 + (x % 10);
            x = x / 10;
        }
        return answer <= Integer.MAX_VALUE && answer >= Integer.MIN_VALUE ? (int) answer : 0;
    }
}
