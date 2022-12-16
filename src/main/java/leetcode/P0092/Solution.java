package leetcode.P0092;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class Solution {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        return reverseBetween(head, left, right, 1);
    }


    public static ListNode reverseBetween(ListNode node, int left, int right, int curIndex) {

        if (node == null) {
            return node;
        }

        if (left == right) {
            return node;
        }

        // 如果当前节点还没到翻转的开始索引，那么继续递归
        if (curIndex < left) {
            node.next = reverseBetween(node.next, left, right, curIndex + 1);
            return node;
        }

        // 当前节点到达开始翻转的节点
        if (curIndex == left) {
            // 记下要翻转的节点的父节点
            Map<ListNode, ListNode> parentMap = new HashMap<>();
            // 下面是翻转过程
            while (curIndex < right) {
                parentMap.put(node.next, node);
                node = node.next;
                curIndex++;
            }

            // 到达这一步说明curIndex == right，记下此时node.next
            ListNode next = node.next;

            ListNode cur = node;
            ListNode parent = parentMap.get(node);
            while (parent != null) {
                cur.next = parent;
                cur = cur.next;
                parent = parentMap.get(parent);
            }
            cur.next = next;
            return node;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode listNode = reverseBetween(l0, 2, 3);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}