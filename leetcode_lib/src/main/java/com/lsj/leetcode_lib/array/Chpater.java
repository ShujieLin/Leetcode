package com.lsj.leetcode_lib.array;

/**
 * @description:
 * @date: 2022/2/16
 * @author: linshujie
 */
public class Chpater {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = {2,3,1,2,4,3};
        int[] nums2 = {1,1,1,1,1,1,1,1};

        System.out.println(Solution.minSubArrayLen(target,nums2));
  }

    static class Solution {
        public static int minSubArrayLen(int target, int[] nums) {
            if (nums.length == 0)
                return 0;
            //子数组的起始下标，子数组的结束下标，子数组的总和
          int start = 0,end = 0 ,sum = 0;
          int tempLenght = Integer.MAX_VALUE;//用于记录最小长度
          while (end < nums.length){
              sum += nums[end];
              while (sum >= target){
                  tempLenght = (end - start + 1) < tempLenght ? (end - start + 1) : tempLenght;
                  sum = sum - nums[start];
                  start++;
              }
              end++;
          }
            System.out.println(end + " " + start + " " + tempLenght);
          return tempLenght == Integer.MAX_VALUE ? 0 : tempLenght;
        }
    }
}
