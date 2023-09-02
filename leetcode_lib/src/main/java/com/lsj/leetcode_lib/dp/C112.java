package com.lsj.leetcode_lib.dp;

import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * File description
 *
 * @author linshujie
 * @date 6/13/2023
 */
public class C112 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                null,
                                new TreeNode(1))));
        boolean b = new Solution().hasPathSum(node, 22);
        System.out.println("b = " + b);

    }

    static class Solution {
        private boolean res = false;

        public boolean hasPathSum(TreeNode root, int targetSum) {
            traverse(root, targetSum);
            return res;
        }

        private void traverse(TreeNode root, int targetSum) {
            if (root == null) return;
            targetSum = targetSum - root.val;
            System.out.println("root = " + root.val + " targetSum = " + targetSum);
            if (root.left == null && root.right == null && targetSum == 0) res = true;

            traverse(root.left, targetSum);
            traverse(root.right, targetSum);
        }
    }
}
