package com.lsj.leetcode_lib.tree;

/**
 * @author: linshujie
 */
public class C101 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return false;
            return traverse(root.left, root.right);
        }

        private boolean traverse(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;

            if (left.val != right.val) return false;
            return traverse(left.left,right.right) && traverse(left.right,right.left);

        }
    }
}
