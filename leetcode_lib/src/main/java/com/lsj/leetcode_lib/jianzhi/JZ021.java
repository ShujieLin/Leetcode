package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.ListNode;
import com.lsj.leetcode_lib.Utils;

/**
 * @author: linshujie
 */
public class JZ021 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;

        ListNode listNode2 = new ListNode(1);
        int n2 = 1;
        ListNode res = new Solution().removeNthFromEnd(listNode2, n2);
        Utils.traverse(res);

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            //找到倒数第n个节点
            //双指针，p1跑到n，p2从头开始，两个指针一起跑，直到p1到结尾，p2就是要删除的节点
            ListNode p1 = dummy;
            for (int i = 0; i < n; i++) {
                p1 = p1.next;
            }
            ListNode p2 = dummy;
            while (p1.next != null){
                p1 = p1.next;
                p2 = p2.next;
            }

            //删除p2
            p2.next = p2.next.next;
            return dummy.next;
        }
    }
}
