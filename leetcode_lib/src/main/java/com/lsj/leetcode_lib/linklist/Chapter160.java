package com.lsj.leetcode_lib.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @date: 2022/6/7
 * @author: linshujie
 */
public class Chapter160 {
    public static void main(String[] args) {
       ListNode listNode = new ListNode(0);
        for (int i = 0; i < 3; i++) {
            listNode = listNode.next;
            listNode.val = i;
        }
    }

    private static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            Set<Integer> integerSet = new HashSet<>();
            while (headA.next != null) {
                integerSet.add(headA.val);
            }

            while (integerSet.iterator().hasNext()) {
                Integer integer = integerSet.iterator().next();
                System.out.println(integer + "\n");
            }
//            for (int value :
//     S              integerSet.) {
//
//            }

            return null;
        }
    }

     static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
