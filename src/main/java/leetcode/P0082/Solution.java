package leetcode.P0082;

/**
 * 给定一个已排序的链表的头head ，删除原始链表中所有重复数字的节点，只留下不同的数字。返回 已排序的链表。
 */
public class Solution {

    public static ListNode deleteDuplicates(ListNode head) {

        head = deleteDuplicates(head, false);
        return head;
    }

    /**
     * @param node
     * @param needDelete 这个参数表明node节点是否是重复的，要不要删除
     * @return
     */
    private static ListNode deleteDuplicates(ListNode node, boolean needDelete) {

        if (node == null) {
            return node;
        }

        ListNode next = node.next;
        if (next == null) {
            if (needDelete) {
                return null;
            } else {
                return node;
            }
        }

        // 当前节点和下一个节点相同，将当前节点删掉，保留下一个节点
        if (node.val == next.val) {

            node.next = next.next;
            next.next = null;

            return deleteDuplicates(node, true);
        }

        if (needDelete) {
            return deleteDuplicates(node.next, false);
        }

        node.next = deleteDuplicates(node.next, false);
        return node;
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode listNode = deleteDuplicates(l0);

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