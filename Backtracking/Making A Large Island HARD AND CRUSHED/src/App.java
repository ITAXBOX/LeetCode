import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int largestIsland(int[][] grid) {
        int answer = 0;
        int n = grid.length;
        int identity = -1;

        HashMap<Integer, Integer> islandsByIdentities = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int island = islandSize(i, j, grid, identity);
                    islandsByIdentities.put(identity--, island);
                    answer = Math.max(answer, island);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    answer = Math.max(answer, mergeIslands(i, j, grid, islandsByIdentities));
                }
            }
        }

        return answer;
    }

    private int islandSize(int i, int j, int[][] grid, int newIdentity) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] <= 0)
            return 0;

        int temp = grid[i][j];
        grid[i][j] = newIdentity;

        return temp + islandSize(i + 1, j, grid, newIdentity) + islandSize(i - 1, j, grid, newIdentity)
                + islandSize(i, j + 1, grid, newIdentity) + islandSize(i, j - 1, grid, newIdentity);
    }

    private int mergeIslands(int i, int j, int[][] grid, HashMap<Integer, Integer> islandsByIdentities) {
        int result = 1;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        HashSet<Integer> processedIdentities = new HashSet<>();

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || x >= grid.length || y < 0 || y >= grid.length) {
                continue;
            }

            int islandIdentity = grid[x][y];

            if (islandIdentity != 0 && processedIdentities.add(islandIdentity))
                result += islandsByIdentities.get(islandIdentity);

        }

        return result;
    }
}