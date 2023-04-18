package com.lsj.leetcode_lib.two_pointer;

/**
 * @author: linshujie
 */
public class FindForEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(4,new ListNode(9,new ListNode(100)))));


        ListNode fromEnd = findFromEnd(head, 4);
        System.out.println("fromEnd.val = " + fromEnd.val);
    }

    // 返回链表的倒数第 k 个节点
    static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head,//第一个指针
                p2 = head;//第二个指针
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
