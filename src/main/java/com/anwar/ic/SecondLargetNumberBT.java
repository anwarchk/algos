package com.anwar.ic;

/**
 * @author Anwar
 */

public class SecondLargetNumberBT {

    private static int findLargest(BinaryTreeNode rootNode) {
        System.out.println("Node = " + rootNode);
        BinaryTreeNode current = rootNode;
        BinaryTreeNode largest = null;
        while (current != null) {
            if (current.right == null) {
                largest = current;
            }
            current = current.right;
        }
        return largest.value;
    }

    public static int findSecondLargest(BinaryTreeNode rootNode) {
        if (rootNode == null || (rootNode.left == null
                && rootNode.right == null)) {
            throw new IllegalArgumentException("Tree must have at least 2 nodes");
        }
        BinaryTreeNode current = rootNode;
        while (true) {
            // case: current is largest and has a left subtree
            // 2nd largest is the largest in that subtree
            if (current.left != null && current.right == null) {
                return findLargest(current.left);
            }
            // case: current is parent of largest, and largest has no children,
            // so current is 2nd largest
            if (current.right != null &&
                    current.right.left == null &&
                    current.right.right == null) {
                return current.value;
            }
            current = current.right;
        }
    }

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode leftSubTree = root.insertLeft(3);
        BinaryTreeNode rightSubTree = root.insertRight(8);
        rightSubTree = rightSubTree.insertRight(12);
        leftSubTree = rightSubTree.insertLeft(10);
        leftSubTree.insertRight(11);

        System.out.printf("Second largest value is %d", findSecondLargest(root));
    }
}
