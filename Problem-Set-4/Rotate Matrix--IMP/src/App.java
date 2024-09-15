public class App {
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i == j) {
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            int low = 0;
            int high = length - 1;
            while (low < high) {
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }

    }

}
