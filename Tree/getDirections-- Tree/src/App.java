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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = findPath(root, startValue, new StringBuilder());

        StringBuilder destPath = findPath(root, destValue, new StringBuilder());

        int i = 0;
        while (i < startPath.length() && i < destPath.length() && startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }
        StringBuilder result = new StringBuilder();
        for (int j = i; j < startPath.length(); j++) {
            result.append('U');
        }
        result.append(destPath.substring(i));

        return result.toString();
    }

    private StringBuilder findPath(TreeNode node, int value, StringBuilder path) {
        if (node == null) {
            return null;
        }
        if (node.val == value) {
            return path;
        }
        path.append('L');
        StringBuilder leftPath = findPath(node.left, value, path);
        if (leftPath != null) {
            return leftPath;
        }
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        StringBuilder rightPath = findPath(node.right, value, path);
        if (rightPath != null) {
            return rightPath;
        }
        path.deleteCharAt(path.length() - 1);

        return null;
    }

}
