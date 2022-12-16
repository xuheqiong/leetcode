package leetcode.P0021;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 */
public class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode current = null;

        while (list1 != null || list2 != null) {

            // list1已经结束，把list2剩余的所有节点接到当前节点
            if (list1 == null) {
                if (head == null) {
                    head = list2;
                }
                if (current != null) {
                    current.next = list2;
                }
                break;
            }

            // list2已经结束，把list1剩余的所有节点接到当前节点
            if (list2 == null) {
                if (head == null) {
                    head = list1;
                }

                if (current != null) {
                    current.next = list1;
                }
                break;
            }

            // list1和list2都还有节点, list1当前节点 <= list2当前节点，那么把list1当前节点接到current上
            if (list1.val <= list2.val) {
                if (head == null) {
                    head = list1;
                }

                if (current == null) {
                    current = list1;
                } else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = list2;
                }
                if (current == null) {
                    current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        l0.next = l1;
        l1.next = l2;

        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;

        ListNode current0 = l0;
        while (current0 != null) {
            System.out.print(current0.val + ",");
            current0 = current0.next;
        }

        System.out.println("\n-----------------");
        current0 = n0;
        while (current0 != null) {
            System.out.print(current0.val + ",");
            current0 = current0.next;
        }

        System.out.println("\n-----------------");
        current0 = mergeTwoLists(l0, n0);
        while (current0 != null) {
            System.out.print(current0.val + ",");
            current0 = current0.next;
        }

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
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