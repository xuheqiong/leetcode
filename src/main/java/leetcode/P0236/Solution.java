package leetcode.P0236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 提示：
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * <p>
 * 思路：一个节点顶多只有一个父亲，用HashMap记下节点的父亲
 */
public class Solution {
    public static TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {

        Map<Integer, TreeNode> parentMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        dfs(root, p, q, parentMap);

        while (p != null) {
            visited.add(p.val);
            p = parentMap.get(p.val);
        }

        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return null;
    }

    private static void dfs(TreeNode root, TreeNode p, TreeNode q, Map<Integer, TreeNode> map) {

        // 如果两个点都找到了，直接返回
        if (map.get(p.val) != null && map.get(q.val) != null) {
            return;
        }

        if (root != null) {
            if (root.left != null) {
                map.put(root.left.val, root);
                dfs(root.left, p, q, map);
            }

            if (root.right != null) {
                map.put(root.right.val, root);
                dfs(root.right, p, q, map);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode p0 = new TreeNode(9);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(7);
        TreeNode p4 = new TreeNode(10);
        TreeNode p5 = new TreeNode(11);
        TreeNode p6 = new TreeNode(15);

        p0.left = p1;
        p0.right = p2;
        p1.right = p3;
        p2.left = p4;
        p4.right = p5;
        p5.right = p6;

        System.out.println(dfs(p0, p5, p4).val);
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