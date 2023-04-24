package com.lsj.leetcode_lib.tree;

/**
 * @author: linshujie
 */
public class Chapter114 {
    public static void main(String[] args) {

    }

    /**
     * 但是注意 flatten 函数的签名，返回类型为 void，也就是说题目希望我们在原地把二叉树拉平成链表。
     *
     * 这样一来，没办法通过简单的二叉树遍历来解决这道题了。
     */
    static class Solution {
        TreeNode dummy = new TreeNode(-1);
        TreeNode p = dummy;//用于辅助制作链表的指针

        public void flatten(TreeNode root) {
            if (root == null) return;
            //思路：遍历，然后连接成链表
            traverse(root);
        }

        private void traverse(TreeNode root) {
            if (root == null) return;
            //连接
            p = new TreeNode(root.val);//新建结点，
            p = p.right;//指针移动到右边一位
            traverse(root.left);
            traverse(root.right);
        }
    }
}
