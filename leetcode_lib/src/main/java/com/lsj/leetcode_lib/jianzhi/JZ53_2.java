package com.lsj.leetcode_lib.jianzhi;

/**
 * @author linshujie
 */
public class JZ53_2 {
    public static void main(String[] args) {

        int[] nums = new int[]{0};
        int[] nums2 = new int[]{0,1,2,3,4,5,6,7,9};

        int[] nums3 = new int[]{0,1,2,4,5,6,7,8};
        int i = new Solution().missingNumber(nums);
        System.out.println("i = " + i);
    }

    static class Solution {

        /**
         * 找出异常，二分法查找，中点值小于实际值，向右搜索；中点值大于实际值，向左搜索。
         * @param nums
         * @return
         */
        public int missingNumber(int[] nums) {
            int left = 0,right = nums.length - 1;

            while (left <= right){
                int mid = left + (right - left)/2;
                if (nums[mid] > mid){//左边异常
                    right = mid - 1;
                }else if (nums[mid] == mid){//右边异常
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
