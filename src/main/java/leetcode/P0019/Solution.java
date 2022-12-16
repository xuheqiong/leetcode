package leetcode.P0019;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 思路：有两个指针，p,q，两个指针相差n个节点，p在前，q在后；q到底时，p的下一个节点即是要删除的节点
 */
public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = null;
        ListNode q = null;

        for (int i = 0; i < n; i++) {
            if (q == null) {
                q = head;
            } else {
                q = q.next;
            }
        }

        while (q.next != null) {
            q = q.next;
            if (p == null) {
                p = head;
            } else {
                p = p.next;
            }
        }

        // 如果p压根就没移动，说明要删除的节点是头节点
        if (p == null) {
            return head.next;
        }

        p.next = p.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(0);
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

//        l0.next = l1;
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        l0 = removeNthFromEnd(l0, 1);

        while (l0 != null) {
            System.out.println(l0.val);
            l0 = l0.next;
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