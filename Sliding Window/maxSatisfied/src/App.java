public class App {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int totalSatisfied = 0;
        int additionalSatisfied = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            } else if (i < minutes)
                additionalSatisfied += customers[i];
        }

        int maxAdditionalSatisfied = additionalSatisfied;

        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                additionalSatisfied -= customers[i - minutes];
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }

        return totalSatisfied + maxAdditionalSatisfied;
    }

}
