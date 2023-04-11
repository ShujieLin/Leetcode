package com.lsj.leetcode_lib;

import java.util.Arrays;

/**
 * @author linshujie
 */
public class Chapter34 {
    public static void main(String[] args) {
        int[] nums2 = new int[]{};
        int[] nums3 = new int[]{2};
        int[] nums4 = new int[]{2,2};
        int[] nums5 = new int[]{2,2,2,5,7,7,9,9,10};

        Solution solution = new Solution();
        int[] searchRange2 = solution.searchRange(nums2, 2);
        System.out.println("searchRange2 = " + Arrays.toString(searchRange2));

        int[] searchRange3 = solution.searchRange(nums3, 1);
        System.out.println("searchRange3 = " + Arrays.toString(searchRange3));

        int[] searchRange4 = solution.searchRange(nums4, 2);
        System.out.println("searchRange4 = " + Arrays.toString(searchRange4));

        int[] searchRange5 = solution.searchRange(nums5, 2);
        System.out.println("searchRange5 = " + Arrays.toString(searchRange5));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1,-1};
            }
            int beginIndex,endIndex;
            beginIndex = binarySearch(nums,target);
            endIndex = binarySearch(nums,target+1);
          /*  if (beginIndex > endIndex){
                return new int[]{-1,-1};
            }else if (beginIndex == endIndex){

            }*/
            return new int[]{beginIndex,endIndex};
        }

        public int binarySearch(int[] nums, int target){
            int left = 0, right = nums.length - 1;
            //计算右边
            while(left < right){
                int mid = left + (right - left) / 2;
                if(nums[mid] < target){
                    left = mid + 1;
                }else{//大于等于都可以，8也可以，9也可以，把有边界包含起来
                    right = mid;
                }
            }
            return left;
        }
    }
}
