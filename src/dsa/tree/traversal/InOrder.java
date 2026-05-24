package dsa.tree.traversal;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class InOrder {
    Node root;

    public InOrder() {
        root = null;
    }

    public void insert(int key) {
        root = insertRecord(this.root, key);
    }

    private Node insertRecord(Node root, int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return root;
        }

        if (key < root.data) {
            root.left = insertRecord(root.left, key);
        } else {
            root.right = insertRecord(root.right, key);
        }
        return root;
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " -> ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " -> ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " -> ");
        }
    }


    public static void main(String[] args) {
        InOrder tree = new InOrder(); // {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}
        tree.insert(8);
        tree.insert(2);
        tree.insert(14);
        tree.insert(5);
        tree.insert(13);
        tree.insert(6);
        tree.insert(4);
        tree.insert(1);

        System.out.println("---In Order---");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.println("---Pre Order---");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println("---Post Order---");
        tree.postOrder(tree.root);
    }
}
