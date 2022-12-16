package leetcode.P0099_unsolved;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 思路：只有两个节点被交换，要么是节点和它的前驱被交换，要么是节点和它的被节点交换
 */
public class Solution {

    public static void recoverTree(TreeNode root) {

        dfs(root);
    }

    private static void dfs(TreeNode node) {


    }

    /**
     * 找到前驱
     *
     * @param node
     * @return
     */
    private static TreeNode findPrecessor(TreeNode node) {
        if (node == null || node.right == null) {
            return node;
        }
        return findPrecessor(node.right);
    }

    /**
     * 找到后继
     *
     * @param node
     * @return
     */
    private static TreeNode findSuccessor(TreeNode node) {
        if (node == null || node.left == null) {
            return node;
        }
        return findSuccessor(node.left);
    }


    public static void main(String[] args) {

        TreeNode p0 = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
//        TreeNode p3 = new TreeNode(3);
//        TreeNode p4 = new TreeNode(7);
//        TreeNode p5 = new TreeNode(15);
//        TreeNode p6 = new TreeNode(7);
//        TreeNode p7 = new TreeNode(1);
//        TreeNode p8 = new TreeNode(2);
//        TreeNode p9 = new TreeNode(20);
//        TreeNode p10 = new TreeNode(21);

        p0.left = p2;
        p2.right = p1;
//        p0.right = p2;
//        p1.left = p3;
//        p1.right = p4;
//        p2.left = p3;
//        p2.right = p4;
//        p3.left = p7;
//        p3.right = p8;
//        p6.left = p9;
//        p6.right = p10;

        recoverTree(p0);
        inorder(p0);
    }

    /**
     * 中序遍历
     *
     * @param tree
     * @return
     */
    private static void inorder(TreeNode tree) {

        if (tree == null) {
            return;
        }

        inorder(tree.left);
//        list.add(tree.val);
        System.out.println(tree.val);
        inorder(tree.right);
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