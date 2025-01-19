
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
    public String smallestFromLeaf(TreeNode root) {
        return Smallest(root, "");
    }

    private String Smallest(TreeNode node, String str) {
        if (node == null)
            return str;
        str = (char) ('a' + node.val) + str;
        if (node.left == null && node.right == null) {
            return str;
        }
        if (node.left == null) {
            return Smallest(node.right, str);
        }
        if (node.right == null) {
            return Smallest(node.left, str);
        }
        String left = Smallest(node.left, str);
        String right = Smallest(node.right, str);
        return left.compareTo(right) <= 0 ? left : right;
    }
}