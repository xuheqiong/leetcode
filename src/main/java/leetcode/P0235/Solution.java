package leetcode.P0235;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * <p>
 * 思路1：一个节点顶多只有一个父亲，设立一个parent指针，遍历一遍所有的节点，将子节点指向父亲节点
 */
public class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == null || q == null) {
            return null;
        }

        // 保证p是较小的那个节点，q是较大的节点
        TreeNode minNode = p.val < q.val ? p : q;
        if (minNode != p) {
            q = p;
            p = minNode;
        }

        // 如果p,q分别在根节点两侧，说明根节点就是最近的公共祖先
        if (root.val > p.val && root.val < q.val) {
            return root;
        }

        // 如果根节点与其中一个节点相等，说明根节点就是最近的公共祖先
        if (root.val == q.val || root.val == p.val) {
            return root;
        }

        // 如果根节点 > q，说明p,q都在根节点左侧
        if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return lowestCommonAncestor(root.right, p, q);
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

        System.out.println(lowestCommonAncestor(p0, p3, p4).val);
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