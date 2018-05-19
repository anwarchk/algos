package com.anwar.ic;

/**
 * @author Anwar
 */

public class BalancedTree {

    private static int findDepth(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;
        int height = 0;
        while (current != null) {
            height++;
            current = current.left;
        }
        return -1;
    }

//    int maxDepth(Node node)
//    {
//        if (node == null)
//            return 0;
//        else
//        {
//            /* compute the depth of each subtree */
//            int lDepth = maxDepth(node.left);
//            int rDepth = maxDepth(node.right);
//
//            /* use the larger one */
//            if (lDepth > rDepth)
//                return (lDepth + 1);
//            else
//                return (rDepth + 1);
//        }
//    }
//
//    /* Driver program to test above functions */
//    public static void main(String[] args)
//    {
//        BinaryTree tree = new BinaryTree();
//
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//
//        System.out.println("Height of tree is : " +
//                tree.maxDepth(tree.root));
//    }

}
