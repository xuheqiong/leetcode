package leetcode.P0222;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 */
public class Solution {
    public static int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // maxHeight和minHeight最多相差1
        int maxHeight = dfsLeft(root.left) + 1;
        int minHeight = dfsRight(root.right) + 1;

        if (maxHeight == minHeight) {
            return (int) Math.pow(2, maxHeight) - 1;
        } else {
            int leftNodes = countNodes(root.left);
            int rightNodes = countNodes(root.right);
            return leftNodes + rightNodes + 1;
        }
    }

    private static int dfsLeft(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return dfsLeft(root.left) + 1;
    }

    private static int dfsRight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return dfsRight(root.right) + 1;
    }

    public static void main(String[] args) {

        TreeNode p0 = new TreeNode(0);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        TreeNode p7 = new TreeNode(7);
        TreeNode p8 = new TreeNode(8);
        TreeNode p9 = new TreeNode(9);
        TreeNode p10 = new TreeNode(10);

        p0.left = p1;
        p0.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;
        p3.left = p7;
//        p3.right = p8;

//        p3.left = p7;
//        p3.right = p8;
//        p6.left = p9;
//        p6.right = p10;

        System.out.println(countNodes(p0));
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
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

}