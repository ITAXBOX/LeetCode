import java.util.ArrayDeque;
import java.util.Queue;

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftSubtree, TreeNode rightSubtree) {
        if (leftSubtree == null && rightSubtree == null) {
            return true;
        }
        if (leftSubtree == null || rightSubtree == null) {
            return false;
        }
        return (leftSubtree.val == rightSubtree.val)
                && isMirror(leftSubtree.left, rightSubtree.right)
                && isMirror(leftSubtree.right, rightSubtree.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode leftSubtree = queue.poll();
            TreeNode rightSubtree = queue.poll();
            if (leftSubtree != null && rightSubtree != null) {
                queue.add(leftSubtree.left);
                queue.add(rightSubtree.right);
                queue.add(leftSubtree.right);
                queue.add(rightSubtree.left);
            } else if (leftSubtree != null || rightSubtree != null) {
                return false;
            }
        }

        return true;
    }
}