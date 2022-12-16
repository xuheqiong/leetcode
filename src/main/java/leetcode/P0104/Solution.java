package leetcode.P0104;

import java.util.*;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明:叶子节点是指没有子节点的节点。
 */
public class Solution {
    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

        TreeNode p0 = new TreeNode(3);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(10);
        TreeNode p4 = new TreeNode(11);
        TreeNode p5 = new TreeNode(15);
        TreeNode p6 = new TreeNode(7);
        TreeNode p7 = new TreeNode(1);
        TreeNode p8 = new TreeNode(2);
        TreeNode p9 = new TreeNode(20);
        TreeNode p10 = new TreeNode(21);

        p0.left = p1;
        p0.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;
        p3.left = p7;
        p3.right = p8;
        p6.left = p9;
        p6.right = p10;

        System.out.println(maxDepth(p0));

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