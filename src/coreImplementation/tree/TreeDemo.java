package coreImplementation.tree;

// Preorder -> Root->Left->Right
// Inorder -> Left->Root->Right
// Preorder -> Left->Right->Root

import java.util.LinkedList;
import java.util.Queue;

public class TreeDemo {

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node node = BinaryTree.buildTree(nodes);
//        BinaryTree.preOrderTraversal(node);
//        BinaryTree.inOrderTraversal(node);
//        BinaryTree.postOrderTraversal(node);
//        BinaryTree.levelOrder(node);
        System.out.println("Count of nodes -> " + BinaryTree.countOfNodes(node));
        System.out.println("Sum of nodes -> " + BinaryTree.sumOfNodes(node));
        System.out.println("Height of tree -> " + BinaryTree.heightOfTree(node));
        System.out.println("Diameter of tree -> " + BinaryTree.diameterOfTreeThroughRoot(node));

    }


    static class BinaryTree {
        static int idx = -1;
        int count = 0;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node node = new Node(nodes[idx]);
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);

            return node;
        }

        public static void preOrderTraversal(Node root) {
            if (root == null) {
//                System.out.println("NULL");
                return;
            }
            System.out.println(root.value);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public static void postOrderTraversal(Node root) {
            if (root == null) {
//                System.out.println("NULL");
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.value);
        }

        public static void inOrderTraversal(Node root) {
            if (root == null) {
//                System.out.println("NULL");
                return;
            }
            inOrderTraversal(root.left);
            System.out.println(root.value);
            inOrderTraversal(root.right);
        }

        public static void levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node remove = q.remove();
                if (remove == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(remove.value + " ");
                    if (remove.left != null) q.add(remove.left);
                    if (remove.right != null) q.add(remove.right);
                }
            }
        }

        public static int countOfNodes(Node root) {
            if (root == null) return 0;
            int leftSubTreeCount = countOfNodes(root.left);
            int rightSubTreeCount = countOfNodes(root.right);
            return leftSubTreeCount + rightSubTreeCount + 1;
        }

        public static int sumOfNodes(Node root) {
            if (root == null) return 0;
            int leftSubTreeSum = sumOfNodes(root.left);
            int rightSubTreeSum = sumOfNodes(root.right);
            return leftSubTreeSum + rightSubTreeSum + root.value;
        }

        public static int heightOfTree(Node root) {
            if (root == null) return 0;
            int leftSubtreeHeight = heightOfTree(root.left);
            int rightSubtreeHeight = heightOfTree(root.right);
            return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
        }

        public static int diameterOfTreeThroughRoot(Node root) {
            if (root == null) return 0;
            int leftSubtreeDiameter = diameterOfTreeThroughRoot(root.left);
            int rightSubtreeDiameter = diameterOfTreeThroughRoot(root.right);
            int totalHeight = heightOfTree(root.left) + heightOfTree(root.right) + 1;
            return Math.max(totalHeight, Math.max(leftSubtreeDiameter, rightSubtreeDiameter));
        }

    }

    static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }
}
