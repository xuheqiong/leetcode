package leetcode.P0230_unsolved;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第k个最小元素（从 1 开始计数）。
 * 思路：中序遍历，遍历到N个就是第N小的
 */
public class Solution {
    public static int kthSmallest(TreeNode root, int k) {
        return 0;
    }

    public static void main(String[] args) {
        TreeNode p0 = new TreeNode(9);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(7);
        TreeNode p4 = new TreeNode(10);
        TreeNode p5 = new TreeNode(11);
        TreeNode p6 = new TreeNode(15);
//        TreeNode p7 = new TreeNode(1);
//        TreeNode p8 = new TreeNode(2);
//        TreeNode p9 = new TreeNode(20);
//        TreeNode p10 = new TreeNode(21);

        p0.left = p1;
        p0.right = p2;
//        p1.left = p3;
        p1.right = p3;
//        p2.left = p5;
        p2.left = p4;
        p4.right = p5;
        p5.right = p6;
//        p6.left = p9;
//        p6.right = p10;

        System.out.println(kthSmallest(p0, 2));

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

    public static class BigTreeNode {
        TreeNode node;
        TreeNode parent;

        BigTreeNode() {

        }

        BigTreeNode(TreeNode node) {
            this.node = node;
        }

        BigTreeNode(TreeNode node, TreeNode parent) {
            this.node = node;
            this.parent = parent;
        }
    }

}