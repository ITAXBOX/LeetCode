import java.util.*;

public class App {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        backtrack(answer, new ArrayList<>(), 0, n);
        return answer;
    }

    private static void backtrack(List<List<String>> res, List<Integer> pos, int row, int n) {
        if (row == n) {
            res.add(formString(pos));
        }
        for (int col = 0; col < n; ++col) {
            if (isValid(pos, row, col)) {
                pos.add(col);
                backtrack(res, pos, row + 1, n);
                pos.remove(pos.size() - 1);
            }
        }
    }

    private static boolean isValid(List<Integer> pos, int row, int col) {
        for (int rowTaken = 0; rowTaken < pos.size(); ++rowTaken) {
            int colTaken = pos.get(rowTaken);
            if (col == colTaken || Math.abs(row - rowTaken) == Math.abs(col - colTaken)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> formString(List<Integer> pos) {
        List<String> res = new ArrayList<>();
        int n = pos.size();
        for (int col : pos) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                if (j == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> answer = solveNQueens(5);
        System.out.println(answer.size());
    }
}
