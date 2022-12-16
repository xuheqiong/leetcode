package leetcode.P0094;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序遍历 。
 */
public class Solution {
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        inorder(root, list);
        return list;
    }

    /**
     * 中序遍历
     *
     * @param tree
     * @param list
     * @return
     */
    private static void inorder(TreeNode tree, List<Integer> list) {

        if (tree == null) {
            return;
        }

        inorder(tree.left, list);
        list.add(tree.val);
        inorder(tree.right, list);
    }

    public static void main(String[] args) {

        TreeNode p0 = new TreeNode(1);
        TreeNode p1 = new TreeNode(1);
//        TreeNode p2 = new TreeNode(6);
//        TreeNode p3 = new TreeNode(3);
//        TreeNode p4 = new TreeNode(7);
//        TreeNode p5 = new TreeNode(15);
//        TreeNode p6 = new TreeNode(7);
//        TreeNode p7 = new TreeNode(1);
//        TreeNode p8 = new TreeNode(2);
//        TreeNode p9 = new TreeNode(20);
//        TreeNode p10 = new TreeNode(21);

        p0.left = p1;
//        p0.right = p2;
//        p1.left = p3;
//        p1.right = p4;
//        p2.left = p3;
//        p2.right = p4;
//        p3.left = p7;
//        p3.right = p8;
//        p6.left = p9;
//        p6.right = p10;

//        System.out.println(inorder());
//        System.out.println(isValidBST(p0));

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