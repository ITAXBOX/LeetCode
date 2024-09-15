public class App {
    public int getMaximumGold(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    answer = Math.max(answer, CollectMoney(grid, i, j));
                }
            }
        }
        return answer;
    }

    private int CollectMoney(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0)
            return 0;
        int temp = grid[i][j];
        grid[i][j] = 0;
        int up = CollectMoney(grid, i + 1, j), down = CollectMoney(grid, i - 1, j), left = CollectMoney(grid, i, j + 1),
                right = CollectMoney(grid, i, j - 1);
        grid[i][j] = temp;
        return temp + Math.max(Math.max(up, down), Math.max(left, right));
    }
}
