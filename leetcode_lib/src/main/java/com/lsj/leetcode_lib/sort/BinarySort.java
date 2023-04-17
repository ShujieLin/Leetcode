package com.lsj.leetcode_lib.sort;

/**
 * @author: linshujie
 */
public class BinarySort {
    static int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
    static int[] nums2 = new int[]{5};
    static int target = -5;

    public static void main(String[] args) {
        int search = new Solution().search3(nums2, target);
        System.out.println("search = " + search);
    }


    static class Solution {
        /**
         * 思路：
         * 前提：nums[left] < nums[right]
         * 找到中间mid
         * 假如num[mid] = target，直接返回
         * 假如nums[mid] > target,左边进行二分
         * 假如nums[mid] < target,右边进行二分
         *
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int midIndex = (left + right) / 2;
            while (nums[left] <= nums[right]) {
                if (nums[midIndex] == target) {
                    return midIndex;
                } else if (nums[midIndex] < target) {
                    left = midIndex + 1;
                    midIndex = (left + right) / 2;
                } else if (nums[midIndex] > target) {
                    right = midIndex - 1;
                    midIndex = (left + right) / 2;
                }
            }
            return -1;
        }

        public int search2(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (nums[left] <= nums[right]) {
                int midIndex = left + (right - left) / 2;
                if (nums[midIndex] == target) {
                    return midIndex;
                } else if (nums[midIndex] < target) {
                    left = midIndex + 1;
                } else if (nums[midIndex] > target) {
                    right = midIndex - 1;
                }
            }
            return -1;
        }

        public int search3(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int midIndex = left + (right - left) / 2;
                if (nums[midIndex] == target) {
                    return midIndex;
                } else if (nums[midIndex] < target) {
                    left = midIndex + 1;
                } else if (nums[midIndex] > target) {
                    right = midIndex - 1;
                }
            }
            return -1;
        }
    }
}

