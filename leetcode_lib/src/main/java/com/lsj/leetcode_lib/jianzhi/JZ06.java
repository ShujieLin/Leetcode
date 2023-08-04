package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.ListNode;
import com.lsj.leetcode_lib.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linshujie
 */
public class JZ06 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
        int[] ints = new Solution2().reversePrint(listNode);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    static class Solution2 {
        public int[] reversePrint(ListNode head) {
            if (head == null) return new int[]{};
            ListNode pre = null;
            ListNode cur = head;

            int size = 0;
            while (cur != null) {
                //保存下一个
                ListNode next = cur.next;
                //指向前面结点
                cur.next = pre;
                //把结点赋值给pre
                pre = cur;
                //跳到下一个
                cur = next;
                size++;
            }
            /*Utils.traverse(pre);*/

            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                if (pre!=null){
                    res[i] = pre.val;
                    pre = pre.next;
                }
            }
            return res;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public int[] reversePrint(ListNode head) {
            //反转链表
            ListNode pre = null, cur = head;
            while (cur != null) {
                //保存下一个，为下次循环做保存工作。
                ListNode next = cur.next;
                //pre = cur.next;//指向前面结点
                cur.next = pre;
                //赋值给pre
                pre = cur;
                //cur指向下一个
                cur = next;
            }

            Utils.traverse(head);
            System.out.println(" = ");
            Utils.traverse(pre);
            return null;
        }
    }
}
