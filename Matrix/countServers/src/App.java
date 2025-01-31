class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] row = new int[n], column = new int[m];
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    column[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || column[j] > 1)) {
                    result++;
                }
            }
        }
        
        return result;
    }
}