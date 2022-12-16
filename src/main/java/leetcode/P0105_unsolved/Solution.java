package leetcode.P0105_unsolved;

/**
 * TODO
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder和inorder均 无重复 元素
 * inorder均出现在preorder
 * preorder保证 为二叉树的前序遍历序列
 * inorder保证 为二叉树的中序遍历序列
 * <p>
 * 中序遍历：中->左->右->中->左->右->中->左->右->中->左->右->中->左->右
 * 前序遍历：左->中->右->左->中->右->左->中->右->左->中->右->左->中->右
 */
public class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        // 如果只有一个节点，那么就是根节点
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        // 根节点是前序遍历的第一个值
        TreeNode root = new TreeNode(preorder[0]);

        // 已知：
        // 最左的，中序遍历的第一个值
        // 最右的，前序、中序遍历的最后一个值

        return root;
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