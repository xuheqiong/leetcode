package leetcode.P0199;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class Solution {
    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        // 如果没有右子树，那么要看左子树
        if (root.right == null) {
            // 把自己加进去
            list.add(root.val);
            List<Integer> list1 = rightSideView(root.left);
            list.addAll(list1);
        } else {
            list.add(root.val);

            List<Integer> leftView = rightSideView(root.left);
            List<Integer> rightView = rightSideView(root.right);

            // 左边的节点比右边的节点少，那么返回右边能看到的节点数
            if (leftView.size() <= rightView.size()) {
                list.addAll(rightView);
            } else {

                list.addAll(rightView);

                for (int i = rightView.size(); i < leftView.size(); i++) {
                    list.add(leftView.get(i));
                }
            }
        }

        return list;
    }

    public static List<Integer> rightSideView0(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return null;
        }

        // 如果没有右子树，那么要看左子树
        if (root.right == null) {
            // 把自己加进去
            list.add(root.val);
            list.addAll(rightSideView(root.left));
        } else {
            list.add(root.val);

            List<Integer> leftView = rightSideView(root.left);
            List<Integer> rightView = rightSideView(root.right);

            // 左边的节点比右边的节点少，那么返回右边能看到的节点数
            if (leftView.size() <= rightView.size()) {
                list.addAll(rightView);
            } else {

                list.addAll(rightView);

                for (int i = rightView.size(); i < leftView.size(); i++) {
                    list.add(leftView.get(i));
                }
            }
        }

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
        p2.left = p5;
        p3.left = p6;
//        p3.left = p7;
//        p3.right = p8;
//        p6.left = p9;
//        p6.right = p10;

        System.out.println(rightSideView(p0));
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