package com.lsj.leetcode_lib.array;

/**
 * @description:
 * @date: 2022/2/15
 * @author: linshujie
 */
public class Chapter485 {
    public static void main(String[] args) {
        int nums[] = {1,1,0,1,1,1};
        int nums2[] = {1,0,1,1,0,1};
        Solution.findMaxConsecutiveOnes(nums2);
    }

    static class Solution {
        public static int findMaxConsecutiveOnes(int[] nums) {
            int slow = 0,fast = 0;
            int tempMax = slow;
            while (fast < nums.length){
                if (nums[fast ++] == 1){
                    slow ++;
                }else {
                    slow = 0;
                }
                tempMax = tempMax > slow ? tempMax : slow;
            }
//            System.out.println(tempMax);
            return tempMax;
        }
    }
}
