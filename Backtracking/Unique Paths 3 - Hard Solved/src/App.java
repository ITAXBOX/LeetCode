public class App {
    private int answer = 0, total;
    int[] directionsX = { 1, -1, 0, 0 };
    int[] directionsY = { 0, 0, 1, -1 };

    public int uniquePathsIII(int[][] grid) {
        total = grid.length * grid[0].length;
        int start = 0, end = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    start = i;
                    end = j;
                } else if (grid[i][j] == -1)
                    total--;
            }
        }
        uniquePaths(start, end, 1, grid);
        return answer;
    }

    private void uniquePaths(int i, int j, int counter, int[][] grid) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != -1)
            if (grid[i][j] == 2 && counter == total) {
                answer++;
            } else {
                int temp = grid[i][j];
                for (int d = 0; d < 4; d++) {
                    int newX = i + directionsX[d];
                    int newY = j + directionsY[d];
                    grid[i][j] = -1;
                    uniquePaths(newX, newY, counter + 1, grid);
                    grid[i][j] = temp;
                }
            }
    }
}
