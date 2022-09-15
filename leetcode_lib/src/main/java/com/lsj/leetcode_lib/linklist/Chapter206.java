package com.lsj.leetcode_lib.linklist;

/**
 *
 * 方法一：迭代
 *
 * 假设链表为
 * 1
 * →
 * 2
 * →
 * 3
 * →
 * ∅
 * 1→2→3→∅，我们想要把它改成
 * ∅
 * ←
 * 1
 * ←
 * 2
 * ←
 * 3
 * ∅←1←2←3。
 *
 * 在遍历链表时，将当前节点的
 * next
 * next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @date: 2022/9/15
 * @author: linshujie
 */
public class Chapter206 {

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}