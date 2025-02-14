class Solution {
    private int m, n;

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;

        Integer[][] memo = new Integer[m][n];

        return dungeonHelper(dungeon, 0, 0, memo);
    }

    private int dungeonHelper(int[][] dungeon, int i, int j, Integer[][] memo) {
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int right = dungeonHelper(dungeon, i, j + 1, memo);
        int down = dungeonHelper(dungeon, i + 1, j, memo);

        int minHealth = Math.min(right, down) - dungeon[i][j];

        memo[i][j] = Math.max(1, minHealth);

        return memo[i][j];
    }
}