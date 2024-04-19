package Metodos;

public class BinaryTree<K extends Comparable<K>, V> {
    private class Node {
        K key;
        V value;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        }

        return node;
    }
    public void printTree() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node != null) {
            System.out.println("Parent: " + node.key +
                    ", Left Child: " + (node.left != null ? node.left.key : "None") +
                    ", Right Child: " + (node.right != null ? node.right.key : "None"));
            printTree(node.left);
            printTree(node.right);
        }
    }
}