package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class C108 {
    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        TreeNode res = new Solution().sortedArrayToBST(nums);
        Utils.infixTraverse(res);
    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {

            return traverse(nums, 0, nums.length - 1);
        }

        private TreeNode traverse(int[] nums, int start, int end) {
            if (start > end) return null;
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = traverse(nums, start, mid - 1);
            root.right = traverse(nums, mid + 1, end);
            return root;
        }
    }
}
