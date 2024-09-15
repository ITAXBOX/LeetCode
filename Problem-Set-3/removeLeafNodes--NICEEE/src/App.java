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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (removeNodes(root, target)) {
            return null;
        }
        return root;
    }

    private boolean removeNodes(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        boolean left = removeNodes(node.left, target);
        if (left) {
            node.left = null;
        }
        boolean right = removeNodes(node.right, target);
        if (right) {
            node.right = null;
        }
        return node.left == null && node.right == null && node.val == target;
    }

}
