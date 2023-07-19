package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ009 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        int i = new Solution().numSubarrayProductLessThanK(nums, k);
        System.out.println("i = " + i);
    }

    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int left = 0, right = 0;
            int product = 1;
            int res = 0;
            while (right < nums.length) {
                product *= nums[right];
                if (product < k) {
                    res = res + (right - left + 1);
                    System.out.println("left = " + left + " right = " + right + " product = " + product );
                }
                right++;

                while (product >= k) {
                    product /= nums[left];
                    left++;
                }
            }

            return res;
        }
    }
}
