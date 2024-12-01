public class App {
    public char[][] rotateTheBox(char[][] box) {
        for (int i = 0; i < box.length; i++) {
            char[] row = box[i];
            int change = -1;

            for (int j = row.length - 1; j >= 0; j--) {
                if (row[j] == '*') {
                    change = -1;
                } else if (row[j] == '#') {
                    row[j] = '.';
                    if (change != -1) {
                        row[change] = '#';
                        change--;
                    } else {
                        int k = j;
                        while (++k != row.length && row[k] != '*');
                        row[k - 1] = '#';
                        change = k - 2;
                    }
                }
            }
        }
        return rotateRight(box);
    }

    public char[][] rotateRight(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] rotated = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = box[i][j];
            }
        }

        return rotated;
    }
}
