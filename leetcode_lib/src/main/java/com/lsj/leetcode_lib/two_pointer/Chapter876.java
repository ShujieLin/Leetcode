package com.lsj.leetcode_lib.two_pointer;

/**
 * @author: linshujie
 */
public class Chapter876 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(4,new ListNode(9/*,new ListNode(100)*/))));
        ListNode middleNode = new Solution().middleNode(head);
        System.out.println("middleNode.val = " + middleNode.val);
    }
    static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode p1 = head,//快指针
                    p2 = head;//慢指针
            
            while (p1 != null && p1.next != null){
                p1 = p1.next.next;
                p2 = p2.next;
            }
            return p2;
        }
    }
}
