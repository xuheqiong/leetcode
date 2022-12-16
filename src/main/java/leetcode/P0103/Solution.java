package leetcode.P0103;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 基本思路：要有两个数据结构记录读出的节点和写入的节点。
 * 队列：无论顺序还是逆序时都要写入
 * 栈：只有逆序时需要写入
 */
public class Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levelOrder = new ArrayList<>();

        // 要把同一层的放在一个列表中
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        // 先把自己推入队列
        queue.add(root);

        // 子节点是否顺序，初始化是逆序的。因为刚开始的根节点默认顺序，那么它的子节点就是逆序
        boolean childIsInorder = false;
        while (!queue.isEmpty()) {

            List<Integer> levelNodes = new ArrayList<>();

            int n = queue.size();
            // 这个循环用于标识某一层的节点数
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                TreeNode levelNode = node;

                // 子节点是逆序的，那么本身就是顺序的
                if (!childIsInorder) {
                    // 如果本身是顺序的，要从队列中获取节点值，并将左右子节点压入栈
                    levelNodes.add(levelNode.val);

                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                } else {
                    // 子节点是顺序的，那么本身就是逆序的，要从栈中获取值
                    levelNode = stack.pop();
                    levelNodes.add(levelNode.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levelOrder.add(levelNodes);

            childIsInorder = !childIsInorder;
        }

        return levelOrder;
    }

    public static void main(String[] args) {

        TreeNode p0 = new TreeNode(3);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(10);
        TreeNode p4 = new TreeNode(11);
        TreeNode p5 = new TreeNode(15);
        TreeNode p6 = new TreeNode(7);
        TreeNode p7 = new TreeNode(1);
        TreeNode p8 = new TreeNode(2);
        TreeNode p9 = new TreeNode(20);
        TreeNode p10 = new TreeNode(21);

        p0.left = p1;
        p0.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;
        p3.left = p7;
        p3.right = p8;
        p6.left = p9;
        p6.right = p10;

        System.out.println(zigzagLevelOrder(p0));

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