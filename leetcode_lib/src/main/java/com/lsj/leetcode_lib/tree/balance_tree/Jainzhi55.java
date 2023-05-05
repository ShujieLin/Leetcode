package com.lsj.leetcode_lib.tree.balance_tree;

import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * @author linshujie
 */
public class Jainzhi55 {


    class Solution {
        public boolean isBalanced(TreeNode root) {
            traverse(root);
            return isBalanced;
        }

        boolean isBalanced = true;

        private int traverse(TreeNode root) {
            if (root == null) return 0;

            int leftDepth = traverse(root.left);
            int rightDepth = traverse(root.right);
            if (Math.abs(leftDepth - rightDepth) > 1) isBalanced = false;
            return Math.max(leftDepth, rightDepth) + 1;//每层+1
        }
    }
}
