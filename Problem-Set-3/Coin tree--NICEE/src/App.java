class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Input: root = [3,0,0]
// Output: 2
// Explanation: From the root of the tree, we move one coin to its left child,
// and one coin to its right child.
public class App {
    private int moves = 0;

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left), right = dfs(node.right);
        moves += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
}
