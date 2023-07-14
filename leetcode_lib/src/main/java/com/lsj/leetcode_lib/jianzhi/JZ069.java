package com.lsj.leetcode_lib.jianzhi;

/**
 * @author linshujie
 */
public class JZ069 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,2};

        int[] nums2 = new int[]{0,1,0};
        int[] nums3 = new int[]{0,10,5,2};
        int i = new Solution().peakIndexInMountainArray(nums3);
        System.out.println("i = " + i);
    }

    static class Solution {
        public int peakIndexInMountainArray(int[] arr) {

            int left = 0,right = arr.length - 1;

            while (left <= right){
                int mid = left + (right - left) / 2;
                if (arr[mid] < arr[mid + 1]){//在峰值左边，向右搜索
                    left = mid + 1;
                }else if (arr[mid] > arr[mid + 1]){
                    right = mid - 1;
                }
            }

            return left;
        }
    }
}
