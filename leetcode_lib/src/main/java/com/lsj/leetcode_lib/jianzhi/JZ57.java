package com.lsj.leetcode_lib.jianzhi;

import java.util.Arrays;

/**
 * File description
 *
 * @author linshujie
 * @date 7/10/2023
 */
public class JZ57 {
    public static void main(String[] args) {
        /*int[] nums = new int[]{2,7,11,15};
        int[] res = new Solution().twoSum(nums, 9);
        System.out.println("Arrays.toString(res) = " + Arrays.toString(res));*/

        int[] nums = new int[] { 10, 26, 30, 47, 60 };
        int[] res = new Solution2().twoSum(nums, 40);
        System.out.println("Arrays.toString(res) = " + Arrays.toString(res));

       /* int[] nums = new int[] { 1 };
        int[] res = new Solution2().twoSum(nums, 40);
        System.out.println("Arrays.toString(res) = " + Arrays.toString(res));*/
    }

    static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];

            int left = 0, right = nums.length - 1;
            while (left < nums.length && right >= 0) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    res[0] = nums[left];
                    res[1] = nums[right];
                    break;
                }
            }
            return res;
        }
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (target == (nums[i] + nums[j])) {
                        res[0] = nums[i];
                        res[1] = nums[j];
                        break;
                    }
                }
            }
            return res;
        }
    }
}
