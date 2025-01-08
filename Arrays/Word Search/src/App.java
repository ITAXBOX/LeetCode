public class App {
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean search(char[][] board, String word, int row, int col, int index) {
        if (index == word.length())
            return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || board[row][col] != word.charAt(index))
            return false;
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = search(board, word, row + 1, col, index + 1) ||
                search(board, word, row - 1, col, index + 1) ||
                search(board, word, row, col + 1, index + 1) ||
                search(board, word, row, col - 1, index + 1);
        board[row][col] = temp;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(board, "ABCCED"));
    }
}
