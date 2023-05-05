package com.lsj.leetcode_lib.tree.balance_tree;

import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * @author linshujie
 */
public class C110 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7,new TreeNode(1),null)));
        boolean balanced = new Solution().isBalanced(node);
        System.out.println("balanced = " + balanced);
    }

    static class Solution {
        private boolean isBalance = true;

        public boolean isBalanced(TreeNode root) {

            traverse(root);
            return isBalance;
        }

        private int traverse(TreeNode root) {
            if (root == null) return 0;

            System.out.println("pre = " + root.val);
            int leftDepth = traverse(root.left);
            int rightDepth = traverse(root.right);
            System.out.println("post = " + root.val + " leftDepth = " + leftDepth+" rightDepth = " + rightDepth  );
            if (Math.abs(leftDepth - rightDepth) > 1) {
                isBalance = false;
            }
            return Math.max(leftDepth,rightDepth) + 1;
        }
    }
}