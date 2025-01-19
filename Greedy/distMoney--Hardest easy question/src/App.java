public class App {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        money -= children;
        if (money / 7 == children - 1 && money % 7 == 3) {
            return children - 2;
        }
        if (money / 7 == children && money % 7 == 0) {
            return children;
        }
        return Math.min(children - 1, money / 7);
    }
}
