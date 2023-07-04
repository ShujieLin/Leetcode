package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.ListNode;

/**
 * @author: linshujie
 */
public class JZ23 {
    public static void main(String[] args) {
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode l1 = new ListNode(4, new ListNode(1, common));
        ListNode l2 = new ListNode(5, new ListNode(0, new ListNode(1, common)));

        ListNode l3 = new ListNode(4, new ListNode(1));
        ListNode l4 = new ListNode(5, new ListNode(0, new ListNode(10)));

        ListNode intersectionNode = new Solution().getIntersectionNode(l3, l4);
        if (intersectionNode != null)
            System.out.println("intersectionNode.val = " + intersectionNode.val);
        else System.out.println("intersectionNode = " + intersectionNode);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode p1 = headA, p2 = headB;

            while (true) {
                if (p1 == p2) break;
                if (p1 != null) {
                    p1 = p1.next;
                } else {
                    p1 = headB;
                }

                if (p2 != null) {
                    p2 = p2.next;
                } else {
                    p2 = headA;
                }
            }
            return p1;
        }
    }
}
