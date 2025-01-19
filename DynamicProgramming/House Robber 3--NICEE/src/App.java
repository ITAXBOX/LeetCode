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

public class App {
    public int rob(TreeNode root) {
        int[] dp = robHelper(root);
        return Math.max(dp[0], dp[1]);
    }

    public static int[] robHelper(TreeNode node) {
        if (node == null)
            return new int[] { 0, 0 };
        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);
        int take = node.val + left[1] + right[1];
        int notTake = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] { take, notTake };
    }
}
