package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.ListNode;
import com.lsj.leetcode_lib.Utils;

/**
 * @author: linshujie
 */
public class JZ52 {
    public static void main(String[] args) {
 /*       ListNode l1 = new ListNode(1, new ListNode(5, new ListNode(2, new ListNode(4))));
        ListNode l2 = new ListNode(3, new ListNode(2, new ListNode(4)));*/

        ListNode common = new ListNode(2, new ListNode(4));
        ListNode l1 = new ListNode(1, new ListNode(5));
        ListNode l2 = new ListNode(3, new ListNode(8, new ListNode(9)));

        ListNode intersectionNode = new Solution().getIntersectionNode(l1, l2);
        Utils.traverse(intersectionNode);
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
        ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                if (p1 != null) {
                    System.out.println("p1 = " + p1.val);
                    p1 = p1.next;
                } else {
                    p1 = headB;
                }
                if (p2 != null) {
                    System.out.println("p2 = " + p2.val);
                    p2 = p2.next;
                } else {
                    p2 = headA;
                }

                //当跑完一个轮回的时候，两个链表都跑到null，p1 = null p2 = null,退出条件
            }
            return p1;
        }
    }

    static class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // p1 指向 A 链表头结点，p2 指向 B 链表头结点
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                // p1 走一步，如果走到 A 链表末尾，转到 B 链表
                if (p1 == null) p1 = headB;
                else p1 = p1.next;
                // p2 走一步，如果走到 B 链表末尾，转到 A 链表
                if (p2 == null) p2 = headA;
                else p2 = p2.next;
            }
            return p1;
        }
    }
// 详细解析参见：
// https://labuladong.github.io/article/?qno=剑指 Offer 52

}
