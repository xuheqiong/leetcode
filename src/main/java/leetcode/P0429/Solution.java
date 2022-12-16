package leetcode.P0429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 */
public class Solution {
    public static List<List<Integer>> levelOrder(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ret = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                levelList.add(cur.val);

                if (cur.children != null) {
                    queue.addAll(cur.children);
                }
            }

            ret.add(levelList);
        }

        return ret;
    }

    public static void main(String[] args) {


    }

    /**
     * Definition for a binary tree node.
     */
    public static class Node {
        int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}