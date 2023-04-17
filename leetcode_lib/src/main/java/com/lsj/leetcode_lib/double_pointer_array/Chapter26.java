package com.lsj.leetcode_lib.double_pointer_array;

/**
 * @author linshujie
 */
public class Chapter26 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};

        int i = new Solution().removeDuplicates(nums);
        System.out.println("i = " + i);
    }

    static class Solution {
        /**
         * 我们让慢指针 slow 走在后面，快指针 fast 走在前面探路，找到一个不重复的元素就赋值给 slow 并让 slow 前进一步。
         * 这样，就保证了 nums[0..slow] 都是无重复的元素，当 fast 指针遍历完整个数组 nums 后，nums[0..slow] 就是整个数组去重之后的结果。
         *
         * @param nums
         * @return
         */
        public int removeDuplicates(int[] nums) {
            int fast = 0, slow = 0;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow]){
                    slow ++;
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            return slow + 1;
        }
    }
}