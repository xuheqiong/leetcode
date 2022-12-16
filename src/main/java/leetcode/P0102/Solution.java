package leetcode.P0102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levelOrder = new ArrayList<>();

        // 要把同一层的放在一个列表中
        Queue<TreeNode> queue = new LinkedList<>();

        // 先把自己推入队列
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();

            List<Integer> levelNodes = new ArrayList<>();
            // 这个循环用于标识某一层的节点数
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            levelOrder.add(levelNodes);
        }

        return levelOrder;
    }

    public static void main(String[] args) {

        TreeNode p0 = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode p3 = new TreeNode(4);
        TreeNode p4 = new TreeNode(5);

        p0.left = p1;
        p0.right = p2;
        p1.left = p3;
        p1.right = null;
        p2.left = null;
        p2.right = p4;

        System.out.println(levelOrder(p0));

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