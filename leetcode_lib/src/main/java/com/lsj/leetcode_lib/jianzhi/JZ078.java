package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.ListNode;
import com.lsj.leetcode_lib.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;

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
        ListNode[] listNodes = new ListNode[]{l1, l2, l3};

        ListNode[] empty1 = new ListNode[1];
        empty1[0] = null;
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
            if (lists == null || lists.length == 0) return null;

            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(new ToIntFunction<ListNode>() {
                @Override
                public int applyAsInt(ListNode value) {
                    return value.val;
                }
            }));

            /*queue.addAll(Arrays.asList(lists));*/

            for (ListNode node :
                    lists) {
                if (node != null) {
                    queue.add(node);
                }
            }

            //用于指向新链表
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;

            while (!queue.isEmpty()) {
                ListNode cur = queue.poll();

                //连接到新链表
                p.next = cur;
                p = p.next;

               /* if (cur !=null){
                    queue.offer(cur.next);
                }*/

                //在每次从队列中取出节点后，应该将该节点的下一个节点添加到队列中，而不是原始链表的下一个节点。当前代码中在循环中没有正确更新该节点的指针。
                if (cur != null && cur.next != null) {
                    cur = cur.next;
                    //放下一个进去
                    queue.offer(cur);
                }
            }

            return dummy.next;
        }
    }

    static class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            // 虚拟头结点
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            // 优先级队列，最小堆
            PriorityQueue<ListNode> pq = new PriorityQueue<>(
                    lists.length, (a, b)->(a.val - b.val));
            // 将 k 个链表的头结点加入最小堆
            for (ListNode head : lists) {
                if (head != null)
                    pq.add(head);
            }

            while (!pq.isEmpty()) {
                // 获取最小节点，接到结果链表中
                ListNode node = pq.poll();
                p.next = node;
                if (node.next != null) {
                    pq.add(node.next);
                }
                // p 指针不断前进
                p = p.next;
            }
            return dummy.next;
        }
    }
// 详细解析参见：
// https://labuladong.github.io/article/?qno=剑指 Offer II 078

}
