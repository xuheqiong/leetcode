package leetcode.P0116_P0117;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 * <p>
 * 提示：
 * 树中节点的数量在[0, 212- 1]范围内
 * -1000 <= node.val <= 1000
 */
public class Solution {
    public static Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node pre = null;
        Node current = null;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                current = queue.poll();

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }


                if (pre != null) {
                    pre.next = current;
                }
                pre = current;
            }
            pre = null;
        }
        return root;
    }


    public static void main(String[] args) {
        Node l0 = new Node(1);
        Node l1 = new Node(2);
        Node l2 = new Node(3);
        Node l3 = new Node(4);
        Node l4 = new Node(5);
        Node l5 = new Node(6);
        Node l6 = new Node(7);

        l0.left = l1;
        l0.right = l2;
        l1.left = l3;
        l1.right = l4;
        l2.left = l5;
        l2.right = l6;

        connect(l0);

        while (true) {

            if (l0.next == null && l0.left == null && l0.right == null) {
                break;
            } else {
                System.out.println(l0.val);

                if (l0.next == null) {

                } else {
                    l0 = l0.next;
                }
            }

        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}