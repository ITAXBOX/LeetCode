public class App {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, gasTank = 0, index = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            gasTank += gas[i] - cost[i];

            if (gasTank < 0) {
                index = i + 1;
                gasTank = 0;
            }
        }

        return totalGas >= totalCost ? index : -1;
    }

}
