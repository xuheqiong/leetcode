package leetcode.P0023;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 思路：用TreeMap
 */
public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        Map<Integer, List<ListNode>> map = new TreeMap<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];

            while (node != null) {
                int val = node.val;
                if (map.containsKey(val)) {
                    List<ListNode> listNodes = map.get(val);
                    listNodes.add(node);
                } else {
                    List<ListNode> listNodes = new ArrayList<>();
                    listNodes.add(node);
                    map.put(val, listNodes);
                }

                node = node.next;
            }
        }

        ListNode head = null;
        ListNode cur = null;
        for (Map.Entry<Integer, List<ListNode>> entry : map.entrySet()) {
            List<ListNode> listNodes = entry.getValue();
            for (ListNode node : listNodes) {
                if (head == null) {
                    head = node;
                    cur = node;
                } else {
                    cur.next = node;
                    cur = cur.next;
                }
            }
            cur.next = null;
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(7);
        ListNode l9 = new ListNode(9);
        l0.next = l3;
        l3.next = l6;
        l6.next = l9;

        l1.next = l4;
        l4.next = l7;

        l2.next = l5;
        l5.next = l8;

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l0;
        listNodes[1] = l1;
        listNodes[2] = l2;
        l0 = mergeKLists(listNodes);

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