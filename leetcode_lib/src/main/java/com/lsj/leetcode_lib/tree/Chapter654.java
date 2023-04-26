package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class Chapter654 {
    public static void main(String[] args) {

        int[] nums = new int[]{3,2,1,6,0,5};
        new Solution().constructMaximumBinaryTree(nums);

    }

    static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return buildNode(nums, 0, nums.length - 1);
        }

        private TreeNode buildNode(int[] nums, int lowIndex, int highIndex) {
            if (lowIndex > highIndex) return null;

            //找到数组的最大值
            int value = Integer.MIN_VALUE;
            int index = 0;
            for (int i = lowIndex; i <= highIndex; i++) {//这里必须是<=,传进来的不是长度，而是最大下标
                if (value < nums[i]){
                    value = nums[i];
                    index = i;
                }
            }

            //新建结点
            TreeNode root = new TreeNode(value);
            //连接左右结点
            root.left = buildNode(nums,lowIndex,index - 1);
            root.right = buildNode(nums,index + 1,highIndex);
            return root;
        }
    }
}