package leetcode.P0002;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode current = null;

        int adder = 0;
        while (l1 != null || l2 != null) {

            // l1已经结束，把l2剩余的所有节点接到当前节点
            if (l1 == null) {
                // 如果还有进位，要把进位算好
                if (adder > 0) {
                    int sum = (l2.val + adder) % 10;
                    adder = (l2.val + adder) / 10;
                    current.next = new ListNode(sum);
                } else {
                    // 没有进位
                    if (head == null) {
                        head = l2;
                    }
                    if (current == null) {
                        current = l2;
                    } else {
                        current.next = l2;
                    }
                }
                current = current.next;
                l2 = l2.next;
            } else if (l2 == null) {
                // l2已经结束，把l1剩余的所有节点接到当前节点
                // 如果还有进位，要把进位算好
                if (adder > 0) {
                    int sum = (l1.val + adder) % 10;
                    adder = (l1.val + adder) / 10;
                    current.next = new ListNode(sum);
                } else {
                    // 没有进位
                    if (head == null) {
                        head = l1;
                    }
                    if (current == null) {
                        current = l1;
                    } else {
                        current.next = l1;
                    }
                }
                current = current.next;
                l1 = l1.next;
            } else {
                // l1和l2都还有节点, l1当前节点 <= l2当前节点，那么把l1当前节点接到current上
                int sum = (l1.val + l2.val + adder) % 10;
                adder = (l1.val + l2.val + adder) / 10;
                ListNode node = new ListNode(sum);

                if (head == null) {
                    head = node;
                }
                if (current == null) {
                    current = node;
                } else {
                    current.next = node;
                    current = current.next;
                }

                l1 = l1.next;
                l2 = l2.next;
            }
        }

        // 最后还有进位
        if (adder > 0) {
            current.next = new ListNode(adder);
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode l0 = new ListNode(3);
        ListNode l1 = new ListNode(7);
//        ListNode l2 = new ListNode(9);
//        ListNode l3 = new ListNode(9);
        l0.next = l1;
//        l1.next = l2;
//        l2.next = l3;

        ListNode n0 = new ListNode(9);
        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(5);
        n0.next = n1;
//        n1.next = n2;

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
        current0 = addTwoNumbers(l0, n0);
        while (current0 != null) {
            System.out.print(current0.val + ",");
            current0 = current0.next;
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