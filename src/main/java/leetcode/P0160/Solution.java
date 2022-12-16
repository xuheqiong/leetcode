package leetcode.P0160;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 思路：用Map记下其中一个链表所有节点的父节点，如果另一个链表的某个节点能在map中找到父节点，那么此节点就是所要找的节点
 */
public class Solution {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == headB) {
            return headA;
        }

        // A只有一个节点
        if (headA.next == null) {
            // A,B都只有一个节点

            // B不止一个节点
            // headB.next == null，说明已经达到最后的节点
            while (headB.next != null) {
                headB = headB.next;
            }

            if (headA == headB) {
                return headA;
            }
            return null;
        }

        // B只有一个节点
        if (headB.next == null) {
            // A,B都只有一个节点

            // A不止一个节点
            while (headA.next != null) {
                headA = headA.next;
            }
            if (headA == headB) {
                return headB;
            }
            return null;
        }

        Map<ListNode, ListNode> map = new HashMap<>();
        map.put(headA, new ListNode());
        while (headA.next != null) {
            map.put(headA.next, headA);
            headA = headA.next;
        }

        while (headB != null) {
            ListNode father = map.get(headB);
            if (father != null) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(3);
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(8);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        l5.next = l0;


        ListNode listNode = getIntersectionNode(l1, l0);

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