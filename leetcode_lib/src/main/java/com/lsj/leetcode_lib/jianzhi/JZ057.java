package com.lsj.leetcode_lib.jianzhi;

import java.util.TreeSet;

/**
 * @author: linshujie
 */
public class JZ057 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int k = 3,t = 0;
        boolean b = new Solution().containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println("b = " + b);
    }

    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

            //滑动窗口
            int left = 0,right = 0;
            while (right < nums.length){
                if (Math.abs(nums[right] - nums[left]) <= t && Math.abs(right - left) <= k ){
                    return true;
                }
                right++;

                while (left<right){
                    left++;
                }
            }
            return false;
        }
    }


    class Solution2 {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Long> window = new TreeSet<>();

            for (int i = 0; i < nums.length; i++) {
                if (i > k) {
                    window.remove((long) nums[i - k - 1]);
                }

                Long ceiling = window.ceiling((long) nums[i] - t);
                if (ceiling != null && ceiling - nums[i] <= t) {
                    return true;
                }

                window.add((long) nums[i]);
            }

            return false;
        }
    }
}