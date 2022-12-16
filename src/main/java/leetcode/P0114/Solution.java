package leetcode.P0114;

import java.util.ArrayList;

/**
 * 给你二叉树的根节点 root ，返回它节点值的前序遍历。
 */
public class Solution {
    public static void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        flatten0(root);
    }


    /**
     * root不会为空
     *
     * @param root
     * @return
     */
    private static ArrayList<TreeNode> flatten0(TreeNode root) {

        // 初始化一个只有两个容量的数组，第0个表示一棵树的根节点，第1个表示该树的最右的节点
        ArrayList<TreeNode> list = new ArrayList<>(2);

        // 左右孩子都为空
        if (root.left == null && root.right == null) {
            list.add(root);
            list.add(root);
            return list;
        }

        // 没有左孩子，只有右孩子，不需要做旋转
        if (root.left == null) {
            ArrayList<TreeNode> rightList = flatten0(root.right);
            list.add(root);
            list.add(rightList.get(1));
            return list;
        }

        // 只有左孩子，没有右孩子
        if (root.right == null) {
            ArrayList<TreeNode> leftList = flatten0(root.left);
            root.right = leftList.get(0);
            root.left = null;

            list.add(root);
            list.add(leftList.get(1));
            return list;
        }

        // 左右孩子都有
        ArrayList<TreeNode> leftTreeList = flatten0(root.left);
        ArrayList<TreeNode> rightTreeList = flatten0(root.right);

        leftTreeList.get(1).right = rightTreeList.get(0);
        root.right = leftTreeList.get(0);
        root.left = null;

        list.add(root);
        list.add(rightTreeList.get(1));

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

        flatten(p0);

        while (p0 != null) {
            System.out.println(p0.val);
            p0 = p0.right;
        }

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