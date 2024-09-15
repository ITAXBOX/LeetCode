public class BinaryTree<E extends Comparable<E>> {
    protected Node<E> root;

    protected static class Node<E> {
        public E data;
        public Node<E> right;
        public Node<E> left;

        public Node(E data) {
            this.data = data;
        }

    }

    protected BinaryTree() {
    }

    protected BinaryTree(E data) {
        this(data, null, null);
    }

    protected BinaryTree(E data, BinaryTree<E> left, BinaryTree<E> right) {
        root = new Node<>(data);
        if (left != null) {
            root.left = left.root;
        }
        if (right != null) {
            root.right = right.root;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public E find(E data) {
        return find(root, data);
    }

    private E find(Node<E> node, E data) {
        if (node == null) {
            return null;
        }
        int compare = node.data.compareTo(data);
        if (compare == 0) {
            return data;
        }
        if (compare < 0) {
            if (node.left.data.equals(data)) {
                return data;
            }
            return find(node.left, data);
        }
        if (node.right.data.equals(data)) {
            return data;
        }
        return find(node.right, data);
    }

    public String postorder() {
        StringBuilder str = new StringBuilder();
        postorder(root, str);
        return str.toString();
    }

    private void postorder(Node<E> node, StringBuilder str) {
        if (node == null) {
            return;
        }
        postorder(node.left, str);
        postorder(node.right, str);
        str.append(node.data);
    }
}
