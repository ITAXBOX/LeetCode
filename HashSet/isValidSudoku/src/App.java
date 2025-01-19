import java.util.HashSet;

public class App {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {

                    char value = board[row][col];
                    int boxIndex = (row / 3) * 3 + (col / 3);

                    if (rows[row].contains(value) || cols[col].contains(value) || boxes[boxIndex].contains(value)) {
                        return false;
                    }

                    rows[row].add(value);
                    cols[col].add(value);
                    boxes[boxIndex].add(value);
                }
            }
        }

        return true;
    }
}
