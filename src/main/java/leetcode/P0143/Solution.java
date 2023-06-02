package leetcode.P0143;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 思路：将链表倒过来，得到Ln->Ln-1->Ln-2->...然后两个链表交叉指向
 *
 * @author xuhq
 * @date 2023/6/2 16:02
 */
public class Solution {
    public void reorderList(ListNode head) {

        Deque<ListNode> reverseList = new LinkedList<>();
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            reverseList.push(cur);
            cur = cur.next;
            length++;
        }

        cur = null;
        ListNode anotherHead = null;
        while (!reverseList.isEmpty()) {
            ListNode pop = reverseList.pop();
            ListNode newNode = new ListNode(pop.val);
            if (anotherHead == null) {
                anotherHead = newNode;
                cur = newNode;
            } else {
                cur.next = newNode;
                cur = cur.next;
            }
        }

        ListNode oldHead = head;
        ListNode newHead = null;
        for (int i = 0; i < length; i++) {
            // 偶数，连原来的链表
            if ((i & 1) == 0) {
                if (newHead == null) {
                    newHead = oldHead;
                    cur = oldHead;
                } else {
                    cur.next = oldHead;
                    cur = cur.next;
                }
                oldHead = oldHead.next;
            } else {
                cur.next = anotherHead;
                anotherHead = anotherHead.next;
                cur = cur.next;
            }
        }
        cur.next = null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        n0.next = n1;

        ListNode n2 = new ListNode(3);
        n1.next = n2;

        ListNode n3 = new ListNode(4);
        n2.next = n3;

        ListNode n4 = new ListNode(5);
        n3.next = n4;

        solution.reorderList(n0);
    }
}

class ListNode {
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