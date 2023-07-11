package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ53_1 {
    public static void main(String[] args) {
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 6;
        int search = new Solution().search(nums, target);
        System.out.println("search = " + search);
    }

    static class Solution {
        /**
         * 二分法寻找左边界和右边界，用右边界-左边界
         */
        public int search(int[] nums, int target) {

            int leftBound = findLeftBound(nums, target);
            System.out.println("leftBound = " + leftBound);

            int rightBound = findRightBound(nums, target);
            System.out.println("rightBound = " + rightBound);

            int res = 0;
            if (leftBound != -1 && rightBound != -1) {
                res = rightBound - leftBound + 1;
            }
            return res;
        }

        private int findRightBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int res = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    res = mid;
                    left++;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }

        private int findLeftBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int res = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                System.out.println("mid = " + mid);
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {//向左逼近
                    res = mid;
                    right--;
                }
            }
            return res;
        }
    }
}