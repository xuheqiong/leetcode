package leetcode.P0061;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动k个位置。
 * 提示：
 *     链表中节点的数目在范围 [0, 500] 内
 *     -100 <= Node.val <= 100
 *     0 <= k <= 2 * 109
 * <p>
 * 思路1：将所有的节点按序存入数组中，再将数组右移即可
 */
public class Solution {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        List<ListNode> ret = new ArrayList<>(list.size());
        // 实际需要移动的次数
        k = k % list.size();
        for (int i = 0; i < list.size(); i++) {
            ret.add(list.get((list.size() - k + i) % list.size()));
        }

        ListNode newHead = null;
        ListNode cur = null;
        for (ListNode node : ret) {
            if (newHead == null) {
                newHead = node;
                cur = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }

        cur.next = null;

        return newHead;
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

        ListNode listNode = rotateRight(l0, 3);

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