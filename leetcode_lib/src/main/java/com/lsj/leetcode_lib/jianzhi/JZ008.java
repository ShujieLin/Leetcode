package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ008 {
    public static void main(String[] args) {
     /*   int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;*/

        int[] nums = new int[]{1,1};
        int target = 4;
        int i = new Solution().minSubArrayLen(target, nums);
        System.out.println("i = " + i);

    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0, right = 0;
            int sum = 0;
            int res = Integer.MAX_VALUE;
            while (right < nums.length) {
                /*if (sum >= target) {
                }*/
                sum += nums[right];
                right++;

                while (sum >= target) {
                    res = Math.min(right - left, res);

                    sum -= nums[left];
                    left++;
                }
            }

            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
}
