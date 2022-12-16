package leetcode.P0098;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 基本思路1：中序遍历
 */
public class Solution {
    public static boolean isValidBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        inorder(root, list);
        if (list.size() == 1) {
            return true;
        }

        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
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
        System.out.println(isValidBST(p0));

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