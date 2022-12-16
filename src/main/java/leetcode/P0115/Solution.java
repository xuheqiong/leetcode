package leetcode.P0115;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class Solution {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);

        return list;
    }


    public static void main(String[] args) {

        TreeNode p0 = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(5);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(6);
        TreeNode p6 = new TreeNode(7);
//        TreeNode p7 = new TreeNode(1);
//        TreeNode p8 = new TreeNode(2);
//        TreeNode p9 = new TreeNode(20);
//        TreeNode p10 = new TreeNode(21);

        p0.left = p1;
        p0.right = p2;
        p1.left = p3;
        p1.right = p4;
//        p2.left = p5;
        p2.right = p5;
        p5.left = p6;
//        p3.left = p7;
//        p3.right = p8;
//        p6.left = p9;
//        p6.right = p10;

        System.out.println(postorderTraversal(p0));
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