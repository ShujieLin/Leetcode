package com.lsj.leetcode_lib.linklist;

/**
 * @author linshujie
 */
public class C92 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5)))));

        ListNode res = new Solution2().reverseBetween(listNode, 2, 4);
        while (res!=null){
            System.out.println("res = " + res.val);
            res = res.next;
        }
    }


    static class Solution2 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || left == right) {
                return head;
            }

            ListNode dummy = new ListNode(0); // 创建带有初始值的 dummy 节点
            dummy.next = head;

            ListNode pre = dummy;
            for (int i = 1; i < left; i++) {
                pre = pre.next;
            }
            ListNode cur = pre.next;

            for (int i = 0; i < right - left; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
               cur = next;
            }
            return dummy.next;
        }

      /*  public ListNode reverseBetween(ListNode head, int left, int right) {

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode pre = dummy;
            for (int i = 1; i < left; i++) {
                pre = pre.next;
            }
            ListNode cur = pre.next;

            for (int i = 0; i < right - left; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return dummy.next;
        }*/
    }
    static class SolutionInCorrect {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            ListNode pre = null;
            ListNode cur = head;
            for (int i = 1; i < left; i++) {
                cur = cur.next;
            }

            while (cur!=null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return head;
        }
    }
}