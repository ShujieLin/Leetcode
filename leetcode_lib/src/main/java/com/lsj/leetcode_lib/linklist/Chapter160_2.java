package com.lsj.leetcode_lib.linklist;

/**
 * @date: 2022/6/10
 * @author: linshujie
 */
public class Chapter160_2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pointA = headA;
        ListNode pointB = headB;
        //假如两个链表相交，那么当pointA和pointB相交点不为null。
        //假如不相交，相交点为null。
        while (pointA != pointB) {
            pointA = pointA == null ? headB : pointA.next;
            pointB = pointB == null ? headA : pointB.next;
        }
        return pointA;
    }
}