public class App {
    public int rob(int[] houses) {
        if (houses.length == 1) {
            return houses[0];
        }

        if (houses.length == 2) {
            return Math.max(houses[0], houses[1]);
        }

        int[] prev = new int[] { houses[0], houses[1] };
        int[] current = new int[] { Math.max(houses[0], houses[1]), Math.max(houses[1], houses[2]) };
        int[] answer = new int[] { current[0], current[1] };

        for (int i = 2; i < houses.length - 1; i++) {
            answer[0] = Math.max(prev[0] + houses[i], current[0]);
            answer[1] = Math.max(prev[1] + houses[i + 1], current[1]);
            prev[0] = current[0];
            prev[1] = current[1];
            current[0] = answer[0];
            current[1] = answer[1];
        }

        return Math.max(answer[0], answer[1]);
    }
}
