package com.lsj.leetcode_lib.two_pointer;

/**
 * @author: linshujie
 */
public class Chapter19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(4,new ListNode(9,new ListNode(100)))));
        ListNode listNode = new Solution().removeNthFromEnd(head, 5);
//        System.out.println("listNode.val = " + listNode.val);

        while (listNode != null){
            System.out.println("listNode.val = " + listNode.val);
            listNode = listNode.next;
        }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //为了防止越界，使用虚拟头结点
            ListNode dummy = new ListNode();
            dummy.next = head;

            //找到需要删除的头结点的前一个节点。
            //1.需要注意，当需要删除第一个结点的时候，head的前面为null的话出现越界，需要通过添加虚拟头结点进行辅助。
            //2.findFromEnd查找的是倒数第几个数，找的时候，在原来链表中添加多少头结点都不影响结果，因为两个指针走到最后的时候，快指针和慢指针的差值都是一样的，慢指针指向的结果都是倒数第k个节点。
            ListNode fromEnd = findFromEnd(dummy, n + 1);//
            fromEnd.next = fromEnd.next.next;
            return dummy.next;
        }

        // 返回链表的倒数第 k 个节点
        ListNode findFromEnd(ListNode head, int k) {
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
}
