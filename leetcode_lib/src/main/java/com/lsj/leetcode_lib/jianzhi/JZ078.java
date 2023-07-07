package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.ListNode;
import com.lsj.leetcode_lib.Utils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * File description
 *
 * @author linshujie
 * @date 7/7/2023
 */
public class JZ078 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] listNodes = new ListNode[] { l1, l2, l3 };

        ListNode lNull = null;
        ListNode[] empty1 = new ListNode[]{lNull};
        ListNode res = new Solution().mergeKLists(empty1);

        Utils.traverse(res);
    }

    static class Solution {
        /**
         * 思路：
         * 使用优先队列，把每个链表的链表头结点添加到优先队列中，因为每个链表都是升序，每次都取队列的最值出来，添加到合并后的链表中
         * 循环过后就是需要的目标链表
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null ) return null;

            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            if (lists.length == 0) return null;
            queue.addAll(Arrays.asList(lists));

            //用于指向新链表
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;

            while (!queue.isEmpty()) {
                ListNode cur = queue.poll();

                //连接到新链表
                p.next = cur;
                p = p.next;

                if (cur.next != null) {
                    cur = cur.next;
                    //放下一个进去
                    queue.offer(cur);
                }
            }

            return dummy.next;
        }
    }
}
