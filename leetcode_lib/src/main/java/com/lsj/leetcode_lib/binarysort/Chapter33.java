package com.lsj.leetcode_lib.binarysort;

/**
 * @author linshujie
 */
public class Chapter33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {3,1};
        int target = 1;
        int search = new Solution().search(nums2, target);
        System.out.println("search = " + search);
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target){
                    return mid;
                }

                if(nums[left] <= nums[mid]){//左边有序
                    if(target >= nums[left] && target < nums[mid]){//并且target就在左边
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }else {//右边有序
                    if(target > nums[mid] && target <= nums[right]){//并且target就在右边
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
