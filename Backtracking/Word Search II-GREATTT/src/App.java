import java.util.*;

class RadixNode {
    Map<Character, RadixNode> children;
    String word;

    public RadixNode() {
        children = new HashMap<>();
    }
}

class RadixTree {
    RadixNode root;

    public RadixTree() {
        root = new RadixNode();
    }

    public void insert(String word) {
        RadixNode temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.children.containsKey(ch)) {
                temp.children.put(ch, new RadixNode());
            }
            temp = temp.children.get(ch);
        }
        temp.word = word;
    }

    public RadixNode getRoot() {
        return root;
    }
}

public class App {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        RadixTree radix = new RadixTree();

        for (String word : words) {
            radix.insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, radix.getRoot(), result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, RadixNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || !node.children.containsKey(c))
            return;

        node = node.children.get(c);
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicates
        }

        board[i][j] = '#'; // Mark as visited
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                dfs(board, ni, nj, node, result);
            }
        }
        board[i][j] = c; // Backtrack
    }
}
