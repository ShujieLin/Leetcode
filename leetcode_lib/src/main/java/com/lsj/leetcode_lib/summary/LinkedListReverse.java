package com.lsj.leetcode_lib.summary;

import com.lsj.leetcode_lib.commonutils.UtilsLinkedList;
import com.lsj.leetcode_lib.ListNode;

/**
 * @author: linshujie
 */
public class LinkedListReverse {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res1 = new Solution1().reverseLinkedList(listNode);
        UtilsLinkedList.traverse(res1);

        System.out.println("------------ ");
        ListNode listNode3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res3 = new Solution3().reverseLinkedList(listNode3);
        UtilsLinkedList.traverse(res3);
    }

    /**
     * 头插法
     */
    static class Solution1 {
        public ListNode reverseLinkedList(ListNode listNode) {
            return reverse(listNode);
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode cur = head;
            ListNode newHead = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = newHead;
                newHead = cur;
                cur = next;
            }

            return newHead;
        }
    }

    /**
     * 原地反转
     */
    static class Solution3 {
        public ListNode reverseLinkedList(ListNode listNode) {
            return reverse(listNode);
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return null;

            ListNode cur = head;
            ListNode next = head.next;
            while (next != null) {
                cur.next = next.next;//cur指向next的next
                next.next = head;//next指向head
                head = next;
                next = cur.next;
            }
            return head;
        }
    }
}