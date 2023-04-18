package com.lsj.leetcode_lib.two_pointer;

/**
 * @author: linshujie
 */
public class Chapter86 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2))))));
        ListNode partition = new Solution().partition(l1, 3);

        while (partition != null){
            System.out.println("partition = " + partition.val);
            partition = partition.next;
        }
    }

    /**
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     * 示例 2：
     *
     * 输入：head = [2,1], x = 2
     * 输出：[1,2]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/partition-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1),  p1 = dummy1,//小于x节点的链表
                    dummy2 = new ListNode(-1),p2 = dummy2,//大于等于x节点的链表
                    p = head;//原链表

            while (p != null){
                if (p.val < x){
                    p1.next = p;//获取原链表的值
                    /*System.out.println("p1 = " + p.val);*/
                    p1 = p1.next;//指针后移一位
                }else {
                    p2.next = p;
                    /*System.out.println("p2 = " + p.val);*/
                    p2 = p2.next;
                }
                //不能单纯通过p来遍历就实现正确的两个链表，因为遍历的最后一个数的时候，必定有其中一个链表是无法走到最后的，他还指向上一次的p
               /* p = p.next;*/
                //遍历一个节点，删除刚刚遍历过的节点
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }

            //这时候p1已经走到最后，把他接到dummy2的前面变成一个链表
            p1.next = dummy2.next;
            return dummy1.next;//返回不要头结点的链表
        }
    }
}
