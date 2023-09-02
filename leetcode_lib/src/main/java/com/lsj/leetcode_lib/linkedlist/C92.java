package com.lsj.leetcode_lib.linkedlist;

import com.lsj.leetcode_lib.ListNode;
import com.lsj.leetcode_lib.commonutils.UtilsLinkedList;

/**
 * @author: linshujie
 */
public class C92 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = new Solution().reverseBetween(list, 2, 4);
        UtilsLinkedList.traverse(res);
    }

    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre  = dummy;
            for (int i = 1; i < left; i++) {
                pre = pre.next;
            }
            ListNode cur = pre.next;
            for (int i = 0; i < right - left; i++) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            return dummy.next;
        }
    }
}