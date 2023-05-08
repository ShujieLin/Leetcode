package com.lsj.leetcode_lib.tree;

/**
 * @author: linshujie
 */
public class C1022 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 0, 1, 0, 1};
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(0, new TreeNode(0), new TreeNode(1)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        new Solution().sumRootToLeaf(treeNode);
    }

    static class Solution {
        public int sumRootToLeaf(TreeNode root) {
            traverse(root);
            return res;
        }

        int path = 0;
        int res = 0;

        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                // 叶子节点
                res += path << 1 | root.val;
                return;
            }
            // 前序位置
            path = path << 1 | root.val;
            traverse(root.left);
            traverse(root.right);
            // 后序位置
            path = path >> 1;
        }
    }
}
