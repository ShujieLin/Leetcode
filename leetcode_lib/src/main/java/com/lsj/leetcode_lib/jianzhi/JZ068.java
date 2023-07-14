package com.lsj.leetcode_lib.jianzhi;

/**
 * @author linshujie
 */
public class JZ068 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 5, 6 };
        int t = 0;
        int i = new Solution().searchInsert(nums, t);
        System.out.println("i = " + i);
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left);
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    return mid;
                }
            }
            return left;
        }
    }
}
