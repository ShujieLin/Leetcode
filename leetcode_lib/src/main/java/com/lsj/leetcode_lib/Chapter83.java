package com.lsj.leetcode_lib;

/**
 * @author linshujie
 */
public class Chapter83 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4))));
        ListNode head2 = new ListNode(1);
        ListNode deleteDuplicates = new Solution().deleteDuplicates(head);

        while (deleteDuplicates != null) {
            System.out.println("deleteDuplicates.val = " + deleteDuplicates.val);
            deleteDuplicates = deleteDuplicates.next;
        }
    }

    static class Solution {
        /**
         * 快慢指针
         * 快指针探路
         * 发现不同的，慢指针前进一步，
         * 快指针赋值给慢指针
         *
         * @param head
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode slow = head,
                    fast = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    slow = slow.next;//先前进一位
                    slow.val = fast.val;//再赋值
                }
                fast = fast.next;
            }

            slow.next = null;
            return head;
        }
    }
}
