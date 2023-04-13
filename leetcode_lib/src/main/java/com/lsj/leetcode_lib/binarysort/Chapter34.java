package com.lsj.leetcode_lib.binarysort;

import java.util.Arrays;

/**
 * @author linshujie
 */
public class Chapter34 {
    public static void main(String[] args) {
        int[] nums2 = new int[]{};
        int[] nums3 = new int[]{2};
        int[] nums4 = new int[]{2, 3, 5, 7};
        int[] nums5 = new int[]{2, 2, 2, 5, 7, 7, 9, 9, 10};

        Solution solution = new Solution();
        int[] searchRange2 = solution.searchRange(nums2, 2);
        System.out.println("searchRange2 = " + Arrays.toString(searchRange2));

        int[] searchRange3 = solution.searchRange(nums3, 1);
        System.out.println("searchRange3 = " + Arrays.toString(searchRange3));

        int[] searchRange4 = solution.searchRange(nums4, 1);
        System.out.println("searchRange4 = " + Arrays.toString(searchRange4));

        int[] searchRange5 = solution.searchRange(nums5, 11);
        System.out.println("searchRange5 = " + Arrays.toString(searchRange5));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            int leftBound = findLeftBound(nums, target);
            int rightBound = findRightBound(nums, target);

            return new int[]{leftBound, rightBound};
        }

        /**
         * 找到右边界
         * 从右左往左搜查
         * 采取[left,right）搜索区间
         */
        private int findRightBound(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    //收缩左边界
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    //收缩左边界
                    left = mid + 1;
                } else {
                    //收缩右边界
                    right = mid;
                }
            }
            //因为是通过 left = mid + 1进行收缩左边界，所以最后的时候一定会往后多移动了一位下标。
            int bound = left - 1;
            //假如找不到右边界，
            if (bound == -1) return -1;
            /* return left - 1;*/
            return nums[bound] == target ? bound : -1;
        }

        /**
         * 找到左边界
         * 采取[left,right）搜索区间
         */
        private int findLeftBound(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    //收缩右侧空间
                    right = mid;//right是开空间，不包含right，所以right = mid就可以收缩空间。
                } else if (nums[mid] < target) {
                    //收缩左侧空间
                    left = mid + 1;
                } else {
                    //收缩右侧空间
                    right = mid;
                }
            }
            //假如不到左边界，left == nums.length
            if (left == nums.length) return -1;
            return nums[left] == target ? left : -1;
        }
    }
}
