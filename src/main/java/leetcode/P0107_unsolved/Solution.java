package leetcode.P0107_unsolved;

import java.util.List;

/**
 * TODO
 * 给你二叉树的根节点 root,返回其节点值 自底向上的层序遍历。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class Solution {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        return null;
    }


    public static void main(String[] args) {

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