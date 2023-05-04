package com.lsj.leetcode_lib.tree.BST;

import com.lsj.leetcode_lib.tree.ListNode;
import com.lsj.leetcode_lib.tree.TreeNode;
import com.lsj.leetcode_lib.tree.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linshujie
 */
public class C109 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        //-10,-3,0,5,9

        TreeNode node = new Solution2().sortedListToBST(listNode);
        Utils.infixTraverse(node);
        System.out.println(" = ========================= =");
        Utils.preTraverse(node);
    }

    /**
     * 中序遍历BST是有序的
     */
    static class Solution2 {

        private ListNode cur;

        public TreeNode sortedListToBST(ListNode head) {
            this.cur = head;
            int length = 0;
            ListNode temp = head;
            while (temp != null) {
                length++;
                temp = temp.next;
            }
            return traverse(0, length - 1);
        }

        private TreeNode traverse(int low, int high) {
            if (low > high) return null;
            int mid = low + (high - low) / 2;

            TreeNode leftNode = traverse(low, mid - 1);
            TreeNode root = new TreeNode(cur.val);
//            System.out.println("cur = " + cur.val);
            cur = cur.next;
            TreeNode rightNode = traverse(mid + 1, high);

            root.left = leftNode;
            root.right = rightNode;
            return root;
        }
    }


    /**
     * 转换为数组
     * 构建平衡二叉树
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> list = toArray(head);
            return traverse(list, 0, list.size() - 1);
        }

        /**
         * 分解，先根节点，后子节点
         */
        private TreeNode traverse(List<Integer> list, int low, int high) {
            if (low > high) return null;

            int mid = low + (high - low) / 2;
            TreeNode rootNode = new TreeNode(list.get(mid));
            rootNode.left = traverse(list, low, mid - 1);
            rootNode.right = traverse(list, mid + 1, high);
            return rootNode;
        }

        private List<Integer> toArray(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return list;
        }
    }
}