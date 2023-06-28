package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.ListNode;
import com.lsj.leetcode_lib.Utils;

/**
 * File description
 *
 * @author linshujie
 * @date 6/28/2023
 */
public class JZ18 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4,
                new ListNode(5,
                        new ListNode(1,
                                new ListNode(9))));
        ListNode res = new Solution().deleteNode(listNode, 4);
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
        public ListNode deleteNode(ListNode head, int val) {
            if (head.val == val) return head.next;
            ListNode p = head;

            while (p.next != null) {
                if (p.next.val == val) {
                    p.next = p.next.next;
                    break;
                }
                p = p.next;
            }

            return head;
        }
    }

    static class Solution2 {
        public ListNode deleteNode(ListNode head, int val) {
            // 存放删除 val 的链表
            ListNode dummy = new ListNode(-1);
            // q 指针负责生成结果链表
            ListNode q = dummy;
            // p 负责遍历原链表
            ListNode p = head;
            while (p != null) {
                if (p.val != val) {
                    // 把值不为 val 的节点接到结果链表上
                    q.next = p;
                    q = q.next;
                }
                // 断开原链表中的每个节点的 next 指针
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }

            return dummy.next;
        }
    }
}