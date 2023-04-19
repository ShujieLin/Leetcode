package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class Chapter104 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        int maxDepth = new Solution().maxDepth(node);
        System.out.println("maxDepth = " + maxDepth);
    }


    static class Solution {
        int depth = 1;
        int result = 0;

        public int maxDepth(TreeNode root) {

            return traverse(root);
        }

        private int traverse(TreeNode root) {
            if (root == null) return 0;
            System.out.println("root.val = " + root.val + " depth = " +depth);
            result = Math.max(depth, result);
            depth++;
            traverse(root.left);
            traverse(root.right);
            depth--;

            return result;
        }
    }
}