package com.lsj.leetcode_lib.two_pointer;

/**
 * @author: linshujie
 */
public class Chapter21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4,new ListNode(9,new ListNode(100)))));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergeTwoLists = new Solution().mergeTwoLists(l1, l2);
        while (true){
            System.out.println("mergeTwoLists = " + mergeTwoLists.val);
            if (mergeTwoLists.next == null) break;
            mergeTwoLists = mergeTwoLists.next;
        }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode l1 = list1,
                    l2 = list2,
                    dymmy = new ListNode(-1),p = dymmy;//头指针

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else if (l1.val == l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                //每次p都需要往后面移动一位，来接入新的节点
                p = p.next;
            }
            //两者比较完之后，把剩余的直接拼接上即可。
            if (l1 != null){
                p.next = l1;
            }
            if (l2 != null){
                p.next = l2;
            }

            return dymmy.next;
        }
    }

    static class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 虚拟头结点
            ListNode dummy = new ListNode(-1), p = dummy;
            ListNode p1 = l1, p2 = l2;

            while (p1 != null && p2 != null) {/**<extend down -200>

             ![](https://labuladong.github.io/pictures/链表技巧/1.gif)
             */
                // 比较 p1 和 p2 两个指针
                // 将值较小的的节点接到 p 指针
                if (p1.val > p2.val) {
                    p.next = p2;
                    p2 = p2.next;
                } else {
                    p.next = p1;
                    p1 = p1.next;
                }
                // p 指针不断前进
                p = p.next;
            }

            if (p1 != null) {
                p.next = p1;
            }

            if (p2 != null) {
                p.next = p2;
            }

            return dummy.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
