package com.lsj.leetcode_lib;

import java.util.Arrays;

/**
 * @author linshujie
 */
public class Chapter167 {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int[] nums = new int[]{2, 3,4};
        int[] nums = new int[]{-1,0};
        int target = -1;
        int[] ints = new Solution().twoSum(nums, target);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    static class Solution {
        /**
         * 左右指针+缩减区间
         *
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left <= right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                } else if (sum < target){
                    left ++;
                }else {
                    right --;
                }
            }
            return new int[]{0,0};
        }
    }
}
