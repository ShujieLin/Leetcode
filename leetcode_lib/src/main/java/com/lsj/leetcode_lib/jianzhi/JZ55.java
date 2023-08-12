package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * @author: linshujie
 */
public class JZ55 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7,
                                new TreeNode(1),
                                new TreeNode(2)))
        );
        boolean balanced = new Solution().isBalanced(node);
        System.out.println("balanced = " + balanced);
    }

    static class Solution {
        private boolean res = true;

        public boolean isBalanced(TreeNode root) {
            //判断左子树的最大深度，判断右子树的最大深度
            //对比左右子树的深度差，返回结果
            int max = traverse(root);
            System.out.println("max = " + max);
            return res;
        }

        private int traverse(TreeNode root) {
            if (root == null) return 0;

            int left = traverse(root.left);
            int right = traverse(root.right);
            System.out.println("root = " + root.val + " left = " + left + " right = " + right);
            if (Math.abs(left - right) > 1) res = false;
            return Math.max(left, right) + 1;
        }
    }
}