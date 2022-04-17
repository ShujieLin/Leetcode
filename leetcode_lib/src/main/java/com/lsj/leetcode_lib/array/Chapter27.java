package com.lsj.leetcode_lib.array;

/**
 * @description:
 * @date: 2022/2/11
 * @author: linshujie
 */
public class Chapter27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        Solution.removeElement(nums,val);
    }

    static class Solution {
        public static int removeElement(int[] nums, int val) {
            //快指针遍历所有元素，慢指针仅仅指向需要输出的元素
            int fast = 0,slow = 0;
            while (fast < nums.length){
                if (nums[fast] != val){
                    nums[slow] = nums[fast];
                    fast ++;
                    slow ++;
                }else {
                    fast ++;
                }
            }
            for (int i:nums
                 ) {
                System.out.println(i);
            }
            System.out.println("slow = " + slow);
            return slow;
        }
    }
}
