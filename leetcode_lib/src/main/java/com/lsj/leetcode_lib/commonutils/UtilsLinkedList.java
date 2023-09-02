package com.lsj.leetcode_lib.commonutils;

import com.lsj.leetcode_lib.ListNode;

/**
 * @author: linshujie
 */
public class UtilsLinkedList {
    public static void traverse(ListNode head) {
        while (head != null) {
            System.out.println("head.val = " + head.val);
            head = head.next;
        }
    }
}
