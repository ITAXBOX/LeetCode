public class App {
    int[][] num = new int[100][100];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return Paths(0, 0, obstacleGrid);
    }

    private int Paths(int i, int j, int[][] obstacleGrid) {
        if (i == obstacleGrid.length || j == obstacleGrid[0].length || obstacleGrid[i][j] == 1)
            return 0;
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1)
            return 1;
        if (num[i][j] == 0)
            num[i][j] = Paths(i + 1, j, obstacleGrid) + Paths(i, j + 1, obstacleGrid);
        return num[i][j];
    }
}
