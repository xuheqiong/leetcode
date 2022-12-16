package leetcode.P0203;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 */
public class Solution {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // 判断当前节点是否要移除的节点
        if (head.val == val) {
            head = head.next;
            // 如果当前节点的下一个节点为空，那么直接返回空
            if (head == null) {
                return null;
            }
            head = removeElements(head, val);

        } else {
            head.next = removeElements(head.next, val);
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(3);
//        ListNode l3 = new ListNode(4);
//        ListNode l4 = new ListNode(5);
//        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(1);
        l0.next = l6;
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;

        ListNode listNode = removeElements(l0, 1);

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