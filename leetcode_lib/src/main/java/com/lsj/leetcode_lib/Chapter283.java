package com.lsj.leetcode_lib;

/**
 * @author linshujie
 */
public class Chapter283 {
    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] nums = new int[]{0};

        new Solution().moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums = " + nums[i]);
        }
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int fast = 0,slow = 0;
            while (fast <nums.length){
                if (nums[fast] != 0){
                    nums[slow] = nums[fast];
                    slow ++;
                }
                fast ++;
            }

            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}
