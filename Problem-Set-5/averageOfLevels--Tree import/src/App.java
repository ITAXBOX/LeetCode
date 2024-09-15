import java.util.*;

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        if (root == null)
            return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = queue.poll();
                sum += curNode.val;

                if (curNode.left != null)
                    queue.offer(curNode.left);
                if (curNode.right != null)
                    queue.offer(curNode.right);
            }
            double avg = sum / levelSize;
            answer.add(avg);
        }
        return answer;
    }
}
