import java.util.ArrayList;
import java.util.List;

//Question 1 
public class App {
    public static int numIslands(char[][] grid) {
        int answer = 0, size = grid.length, innerSize = grid[0].length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < innerSize; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    Dollar(i, j, grid);
                }
            }
        }
        return answer;
    }

    private static void Dollar(int i, int j, char[][] grid) {
        grid[i][j] = '$';
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            Dollar(i + 1, j, grid);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            Dollar(i - 1, j, grid);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
            Dollar(i, j + 1, grid);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            Dollar(i, j - 1, grid);
        }
    }
}

// Question 2
class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> result = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] coordinates = exploreGroup(i, j, land);
                    result.add(coordinates);
                }
            }
        }

        int[][] resultArray = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private int[] exploreGroup(int row, int col, int[][] land) {
        int m = land.length;
        int n = land[0].length;

        int r1 = row;
        int c1 = col;

        // Find bottom right corner of the group
        int r2 = row;
        int c2 = col;
        while (r2 < m && land[r2][col] == 1) {
            r2++;
        }
        while (c2 < n && land[row][c2] == 1) {
            c2++;
        }

        // Mark the group as visited
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                land[i][j] = 0;
            }
        }

        return new int[] { r1, c1, r2 - 1, c2 - 1 };
    }
}

// Question 3
class Islands {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return IslandTraversal(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int IslandTraversal(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        int perimeter = 0;
        perimeter += IslandTraversal(grid, i + 1, j);
        perimeter += IslandTraversal(grid, i - 1, j);
        perimeter += IslandTraversal(grid, i, j + 1);
        perimeter += IslandTraversal(grid, i, j - 1);
        return perimeter;
    }
}
