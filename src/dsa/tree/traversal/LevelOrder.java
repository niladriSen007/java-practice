package dsa.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

class NodeII {
    int data;
    NodeII left;
    NodeII right;

    public NodeII(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LevelOrder {
    NodeII root;

    public LevelOrder() {
        root = null;
    }

    public void insert(int key) {
        root = insertRecordII(this.root, key);
    }

    private NodeII insertRecordII(NodeII root, int key) {
        NodeII newNode = new NodeII(key);
        if (root == null) {
            root = newNode;
            return root;
        }

        if (key < root.data) {
            root.left = insertRecordII(root.left, key);
        } else {
            root.right = insertRecordII(root.right, key);
        }
        return root;
    }

    public void levelOrder() {
        if (root == null) return;
        Queue<NodeII> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            NodeII node = queue.poll();
            System.out.print(node.data + " -> ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        LevelOrder treeII = new LevelOrder(); // {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}
        treeII.insert(8);
        treeII.insert(2);
        treeII.insert(14);
        treeII.insert(5);
        treeII.insert(13);
        treeII.insert(6);
        treeII.insert(4);
        treeII.insert(1);

        treeII.levelOrder();

    }
}
