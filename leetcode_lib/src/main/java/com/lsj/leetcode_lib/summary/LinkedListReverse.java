package com.lsj.leetcode_lib.summary;

import com.lsj.leetcode_lib.ListNode;
import com.lsj.leetcode_lib.commonutils.UtilsLinkedList;

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

        System.out.println("------------ ");
        ListNode listNode4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res4 = new Solution4().reverseLinkedList(listNode4);
        UtilsLinkedList.traverse(res4);

        System.out.println("------------ ");
        ListNode listNode5 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res5 = new Solution5().reverseLinkedList(listNode5);
        UtilsLinkedList.traverse(res5);
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
            if (head == null || head.next == null) return head;

            ListNode cur = head;
            ListNode next = cur.next;
            while (next != null) {
                cur.next = next.next;
                next.next = head;
                head = next;
                next = cur.next;
            }
            return head;
        }
    }

    /**
     * 递归反转
     */
    static class Solution4 {
        public ListNode reverseLinkedList(ListNode head) {
            return reverse(head);
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode last = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }

    static class Solution5 {
        public ListNode reverseLinkedList(ListNode head) {
            return reverse(head);
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = pre.next;

            while (cur.next != null){
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            return dummy.next;
        }
    }
}