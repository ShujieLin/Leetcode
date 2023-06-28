package com.lsj.leetcode_lib;

/**
 * File description
 *
 * @author linshujie
 * @date 6/28/2023
 */
public class Utils {

    public static void traverse(ListNode listNode){
        ListNode p = listNode;
        while (p != null){
            System.out.println("p.val = " + p.val);
            p = p.next;
        }
    }
}
