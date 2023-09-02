package com.lsj.leetcode_lib.linkedlist;

/**
 * @date: 2022/6/13
 * @author: linshujie
 */
public class Chapter19 {

    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) return null;
            if (head.next == null) return head;

            int size = 0;
            while (head.next != null) {
                head = head.next;
                size += 1;
            }
            int index = size - n;

            for (int i = 0; i < index - 1; i++) {
                head = head.next;
            }
            head.next = head.next.next;

            return head;
        }

        public ListNode removeNthFromEnd2(ListNode head, int n) {
            //利用head计算长度
            int lenght = 0;
            while (head != null) {
                head = head.next;
                lenght++;
            }

            //哑节点，方便统一所有操作的代码
            ListNode dummy = new ListNode(0, head);

            ListNode cur = dummy;
            for (int i = 1; i < lenght - n - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            ListNode result = dummy.next;
            return result;
        }

    }

    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            int length = getLength(head);
            ListNode cur = dummy;
            for (int i = 1; i < length - n + 1; ++i) {
                cur = cur.next;
            }
            cur.next = cur.next.next;

            ListNode ans = dummy.next;
            return ans;
        }

        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                ++length;
                head = head.next;
            }
            return length;
        }
    }

    class Solution3 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //添加辅助节点
            ListNode listNode = new ListNode(0,head);

            //获取长度
            int length = 0;
            while (head != null){
                head = head.next;
                ++length;
            }

            //获取正向index
            int index = length - n;

            ListNode result = listNode;
            //删除，由于前驱节点是额外增加的，所以需要+1
            for (int i = 0; i < (index - 1) + 1; i++) {
                listNode = listNode.next;
            }
            listNode.next = listNode.next.next;

            //返回
            result = result.next;
            return result;
        }
    }

}

