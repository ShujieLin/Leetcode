package com.lsj.leetcode_lib.tree;

/**
 * @author: linshujie
 */
public class C124 {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode node2 = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        int maxPathSum = new Solution().maxPathSum(node2);
        System.out.println("maxPathSum = " + maxPathSum);
    }

    static class Solution {

        private int res;

        public int maxPathSum(TreeNode root) {
            res = 0;
            return traverse(root);
        }

        private int traverse(TreeNode root) {
            if (root == null) return 0;
            System.out.println("->");
            int left = traverse(root.left);
            int right = traverse(root.right);
            res = Math.max(left + right + root.val, res);
            System.out.printf("<- res = %s \n", res + root.val);
            return Math.max(left,right) + root.val;
        }
    }


}
