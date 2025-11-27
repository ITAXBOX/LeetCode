public class RottingOranges {
    private static class Orange {
        private int i;
        private int j;
        private int minute;

        public Orange(int i, int j, int minute) {
            this.i = i;
            this.j = j;
            this.minute = minute;
        }
    }

    public int orangesRotting(int[][] grid) {
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Deque<Orange> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 2)
                    queue.offer(new Orange(i, j, 0));

        int result = 0;

        while (!queue.isEmpty()) {
            Orange orange = queue.poll();
            result = orange.minute;
            for (int i = 0; i < directions.length; i++) {
                int indx = orange.i + directions[i][0];
                int jndx = orange.j + directions[i][1];

                if (indx >= 0 && indx < grid.length && jndx >= 0 && jndx < grid[0].length && grid[indx][jndx] == 1) {
                    grid[indx][jndx] = 2;
                    queue.offer(new Orange(indx, jndx, orange.minute + 1));
                }
            }
        }

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1)
                    return -1;

        return result;
    }
}