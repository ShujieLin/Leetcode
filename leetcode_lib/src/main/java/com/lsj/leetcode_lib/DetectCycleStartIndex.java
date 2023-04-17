package com.lsj.leetcode_lib;

/**
 * @author linshujie
 */
public class DetectCycleStartIndex {

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        ListNode fourthNode = new ListNode(4);

        headNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = secondNode;

        ListNode cycleStartIndex = detectCycleStartIndex(headNode);
        System.out.println("cycleStartIndex = " + cycleStartIndex.val);
    }

    /**
     * 快慢指针
     * 快指针走两步，慢指针走一步
     * 两个指针相遇
     * 让其中一个指针回到head，并以同样速度出发，再次相遇的时候就在圆环的起点
     *
     * @param head
     * @return
     */
    static ListNode detectCycleStartIndex(ListNode head) {
        ListNode fast = head,
                slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        //假如没有圆环
        if (fast == null || slow == null) return null;

        slow = head;
        while (slow != fast && fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}