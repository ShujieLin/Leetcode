package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.ListNode;
import com.lsj.leetcode_lib.Utils;

/**
 * @author: linshujie
 */
public class JZ027 {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode listNode2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
        boolean palindrome = new Solution2().isPalindrome(listNode2);
        System.out.println("palindrome = " + palindrome);
    }


    static class Solution2 {
        public boolean isPalindrome(ListNode head) {
            ListNode node = new ListNode();
            ListNode reverseNode = reverse(node);
            Utils.traverse(head);
            System.out.println(" ------- ");
            Utils.traverse(reverseNode);
            while (head != null && reverseNode != null) {
                if (head.val != reverseNode.val) return false;
                head = head.next;
                reverseNode = reverseNode.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {
            ListNode cur = head, pre = null;
            while (cur != null) {
                //保存cur的下一个结点
                ListNode next = cur.next;
                //指向pre
                cur.next = pre;
                //把cur赋值给pre
                pre = cur;
                //cur指向一开始就保存好的下一个节点
                cur = next;
            }
            return pre;
        }

        private ListNode reverseOnNew(ListNode head) {
            ListNode cur = head, pre = null;
            while (cur != null) {
                //保存cur的下一个结点
                ListNode next = cur.next;
                //指向pre
                cur.next = pre;
                //把cur赋值给pre
                pre = cur;
                //cur指向一开始就保存好的下一个节点
                cur = next;
            }
            return pre;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode reverse = reverse(head);
            Utils.traverse(reverse);
            return false;
        }

        ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;//指向pre节点
                pre = cur;//pre
                cur = next;//cur跑到
            }
            return pre;
        }
    }
}
