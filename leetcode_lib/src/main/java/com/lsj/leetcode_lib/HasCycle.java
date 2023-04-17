package com.lsj.leetcode_lib;

/**
 * @author linshujie
 */
public class HasCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

    }

    boolean hasCycle(ListNode head) {
        ListNode fastP = head,
                slowP = head;
        while (fastP != null && fastP.next != null) {
            fastP = fastP.next.next;
            slowP = slowP.next;
            if (fastP == slowP) return true;
        }
        return false;
    }
}
