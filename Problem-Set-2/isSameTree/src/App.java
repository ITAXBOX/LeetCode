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

class App {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val)
            return false;

        Queue<TreeNode[]> queue = new ArrayDeque<>();
        queue.offer(new TreeNode[] { p, q });

        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];

            if (node1 == null && node2 == null)
                continue;

            if (node1 == null || node2 == null || node1.val != node2.val)
                return false;

            queue.offer(new TreeNode[] { node1.left, node2.left });
            queue.offer(new TreeNode[] { node1.right, node2.right });
        }
        return true;
    }
}