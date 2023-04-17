package com.lsj.leetcode_lib;

/**
 * @author linshujie
 */
public class Chapter27 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,3,4,2};
        int val = 3;
        int removeElement = new Solution().removeElement(nums, val);
        System.out.println("removeElement = " + removeElement);
    }

    static class Solution {
        /**
         * 快慢指针
         * 快指针探路，和慢指针比较，遇到不同的数值的时候
         * 慢指针往前走一步，快指针把当前值赋给慢指针
         * @param nums
         * @param val
         * @return
         */
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) return 0;
            int fast = 0, slow = 0;
            while (fast < nums.length){
                if (nums[fast] != val){
                    nums[slow] = nums[fast];
                    slow ++;
                }
                fast ++;
            }
            for (int i = 0; i < nums.length; i++) {
                System.out.println("nums = " + nums[i]);
            }
            return slow;
        }
    }

}


