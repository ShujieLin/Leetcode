package com.lsj.leetcode_lib.linkedlist;

/**
 * @date: 2022/6/8
 * @author: linshujie
 */
public class Chapter141 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);

        ListNode pre = head;
        ListNode toAdd = new ListNode(1);
        toAdd.next = pre.next;
        pre.next = toAdd;

        ListNode test = head;
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }

        System.out.println(new Solution().hasCycle2(head));

    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            if (head.next == null) return false;

            ListNode fast = head.next;
            ListNode slow = head;
            while (fast != null
                    && slow != null) {
                if (fast == slow) return true;

                //fast.next不能为null
                fast = fast.next.next;
                slow = slow.next;
            }
            return false;
        }


        public boolean hasCycle2(ListNode head) {
            if (head == null) return false;

            ListNode slow = head;
            ListNode fast = head.next;
            //假如不相等，循环跑
            while (slow != fast){
                //假如假如一个为null，说明没有环
                if (fast == null ||fast.next == null) return false;
                slow = slow.next;
                fast = fast.next.next;
            }

            return true;
        }
    }

}
