package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class C100 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return traverse(p, q);
        }

        private boolean traverse(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            return traverse(p.left, q.left) && traverse(p.right, q.right);
        }
    }
}
