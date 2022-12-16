package leetcode.P0101;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称
 */
public class Solution {
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode leftChild, TreeNode rightChild) {

        if (leftChild == null && rightChild == null) {
            return true;
        } else if (leftChild == null) {
            return false;
        } else if (rightChild == null) {
            return false;
        } else if (leftChild.val != rightChild.val) {
            return false;
        } else {
            return isSymmetric(leftChild.left, rightChild.right) && isSymmetric(leftChild.right, rightChild.left);
        }
    }

    public static void main(String[] args) {

        TreeNode p0 = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(4);
        TreeNode p6 = new TreeNode(3);

        p0.left = p1;
        p0.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;


        TreeNode q0 = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        TreeNode q4 = new TreeNode(4);
        TreeNode q5 = new TreeNode(4);
        TreeNode q6 = new TreeNode(3);

        q0.left = q1;
        q0.right = q2;
        q1.left = q3;
        q1.right = q4;
        q2.left = q5;
        q2.right = q6;

        System.out.println(isSymmetric(p0));

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