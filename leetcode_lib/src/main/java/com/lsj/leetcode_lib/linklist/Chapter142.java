package com.lsj.leetcode_lib.linklist;

/**
 * @date: 2022/5/28
 * @author: linshujie
 */
public class Chapter142 {
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        while (fast != null) {

            //slow走一步
            slow = slow.next;
            //fast走两步，直到fast==null，假如不存在fast==null，说明存在环
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            //假如fast和slow相遇，说明存在环
            if (fast == slow) {
                //根据计算，相遇点到入环点的距离加上n-1圈的环长，等于链表头到入环点的距离
                //new一个ptr链表，他和slow每次移动一个位置，最终会在环点相遇
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }

        }
        return null;
    }


    public ListNode detectCycle2(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.next == null) return null;

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                ListNode temp = head;
                while (slow != temp){
                    temp = temp.next;
                    slow = slow.next;
                }
               return temp;
            }

        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

//作者：LeetCode-Solution
//        链接：https://leetcode.cn/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
