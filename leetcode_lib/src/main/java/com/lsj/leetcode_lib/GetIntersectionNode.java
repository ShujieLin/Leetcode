package com.lsj.leetcode_lib;

/**
 * @author linshujie
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(10, new ListNode(20));
        ListNode lCommon = new ListNode(100);
        l1.next = lCommon;
        l2.next = lCommon;
        ListNode intersectionNode = getIntersectionNode(l1, l2);
        System.out.println("intersectionNode = " + intersectionNode == null ? intersectionNode : intersectionNode.val);
    }


    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {//假如走完一轮都没有找到相同的结点，那么这时候p1和p2都是null，退出循环
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