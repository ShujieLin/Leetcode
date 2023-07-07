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

     /*   ListNode res = new Solution().detectCycle(n1);
        System.out.println("res.val = " + res.val);*/


        ListNode n10 = new ListNode(1);
        ListNode n11 = new ListNode(2);
        n10.next = n11;
        n11.next = n10;
        ListNode res2 = new Solution().detectCycle(n10);
        System.out.println( res2 == null ? res2 :res2.val);
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
            while (pFast != null && pFast.next != null) {
                pFast = pFast.next.next;
                pSlow = pSlow.next;

                if (pFast == pSlow) {
                    break;
                }
            }
            //System.out.println("pFast = " + pFast.val + " pSlow = " + pSlow.val);

            if (pFast == null || pFast.next == null) return null;


            //相遇后其中一个从头开始，另一个位置不变。一起同步数继续走，直到第二次相遇，相遇点就是环起点
            pSlow = head;

     /*       while (pSlow != null && pFast != null) {
                pFast = pFast.next;
                pSlow = pSlow.next;
                if (pFast == pSlow) break;
            }*/

      /*      while (pFast != pSlow){
                pFast = pFast.next;
                pSlow = pSlow.next;
            }*/

            while (true){
                if (pFast == pSlow) break;
                pFast = pFast.next;
                pSlow = pSlow.next;
            }
            return pSlow;
        }
    }

    static class Solution2 {
        public ListNode detectCycle(ListNode head) {
            ListNode fast, slow;
            fast = slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) break;
            }
            // 上面的代码类似 hasCycle 函数
            if (fast == null || fast.next == null) {
                // fast 遇到空指针说明没有环
                return null;
            }

            // 重新指向头结点
            slow = head;
            // 快慢指针同步前进，相交点就是环起点
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    // 详细解析参见：
    // https://labuladong.github.io/article/?qno=剑指 Offer II 022
}