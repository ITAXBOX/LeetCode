import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = -1;

        int direction = 1;

        List<Integer> result = new ArrayList<>();

        while (rows > 0 && cols > 0) {

            for (int i = 0; i < cols; i++) {
                col += direction;
                result.add(matrix[row][col]);
            }
            rows--;

            for (int i = 0; i < rows; i++) {
                row += direction;
                result.add(matrix[row][col]);
            }
            cols--;

            direction *= -1;
        }
        return result;
    }

    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];

        int rows = n;
        int cols = n;

        int row = 0;
        int col = -1;

        int number = 1;
        int direction = 1;

        while (rows > 0 && cols > 0) {

            for (int i = 0; i < cols; i++) {
                col += direction;
                answer[row][col] = number++;

            }
            rows--;

            for (int i = 0; i < rows; i++) {
                row += direction;
                answer[row][col] = number++;
            }
            cols--;

            direction *= -1;
        }
        return answer;
    }
}