package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.ListNode;
import com.lsj.leetcode_lib.Utils;

/**
 * File description
 *
 * @author linshujie
 * @date 6/29/2023
 */
public class JZ25 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(4)));
        ListNode listNode2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));
        ListNode res = new Solution().mergeTwoLists(listNode, listNode2);
        Utils.traverse(res);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode q = dummy;
            ListNode p1 = l1, p2 = l2;

            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    q.next = p1;
                    p1 = p1.next;
                } else {
                    q.next = p2;
                    p2 = p2.next;
                }
                q = q.next;
            }
            if (p1 != null) {
                q.next = p1;
            }
            if (p2 != null) {
                q.next = p2;
            }

            return dummy.next;
        }
    }
}
