package leetcode.P0025_unsolved;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * 思路：每两个一组翻转
 */
public class Solution {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (k <= 1) {
            return head;
        }

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode cur1 = head;
        // 记录下总共运行了几个节点
        int count = 0;


        ListNode cur2 = null;
        Deque<ListNode> deque = new ArrayDeque<>();
        // 每两个翻一组
        int everyRound = 2;
        for (int i = 0; i < everyRound; i++) {
            deque.push(cur1);
            cur1 = cur1.next;
            count++;
        }

        while (!deque.isEmpty()) {
            if (cur2 == null) {
                newHead = cur2 = deque.pop();
            } else {
                cur2.next = deque.pop();
            }
        }
        cur2.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

//        l0 = reverseKGroup(l0);

        while (l0 != null) {
            System.out.println(l0.val);
            l0 = l0.next;
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