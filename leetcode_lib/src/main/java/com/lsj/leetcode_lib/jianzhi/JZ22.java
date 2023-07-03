package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.ListNode;

/**
 * @author: linshujie
 */
public class JZ22 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;


        ListNode res = new Solution().detectCycle(n1);
        System.out.println("res.val = " + res.val);

    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    static class Solution {
        public ListNode detectCycle(ListNode head) {

            //快慢指针，fast两步，slow一步，同时走直到相遇
            ListNode pFast = head, pSlow = head;
            while (head.next != null) {
                pFast = pFast.next.next;
                pSlow = pSlow.next;

                if (pFast == pSlow) break;
            }

            //相遇后其中一个从头开始，另一个不变，一起继续走，直到第二次相遇，相遇点就是环起点
            pSlow = head;
            while (head.next != null) {
                pFast = pFast.next.next;
                pSlow = pSlow.next;
                if (pFast == pSlow) break;
            }
            return pSlow;
        }
    }
}
