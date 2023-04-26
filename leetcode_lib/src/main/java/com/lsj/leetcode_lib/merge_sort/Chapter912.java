package com.lsj.leetcode_lib.merge_sort;

import java.util.Arrays;

/**
 * @author linshujie
 */
public class Chapter912 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1,2,4};
        int[] ints = new Solution().sortArray(nums);
        System.out.println("ints = " + Arrays.toString(ints));
        /*Merge.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));*/
    }

    static class Solution {
        //存储每次递归中的临时数组
        private int[] temp;

        public int[] sortArray(int[] nums) {
            if (nums.length == 1) return nums;
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        void sort(int[] nums, int low, int high) {
            if (low == high) return;
            int mid = low + (high - low) / 2;
            sort(nums, low, mid);
            sort(nums, mid + 1, high);

            //后序遍历，把分解完的两个数组进行合并
            merge(nums, low, mid, high);
        }

        /**
         * 将nums[low...mid] 和 num[mid+1...high]这两个有序数组进行合并
         *
         * @param nums
         * @param low
         * @param mid
         * @param high
         */
        private void merge(int[] nums, int low, int mid, int high) {
            //把每次传进来的通过边界界定的数组进行存储
            for (int i = low; i <= high; i++) {
                temp[i] = nums[i];
            }

            int i = low, j = mid + 1;
            for (int p = low; p <= high; p++) {
                if (i == mid + 1) {//i指针跑完了
                    nums[p] = temp[j++];
                } else if (j == high + 1) {//j指针跑完了
                    nums[p] = temp[i++];
                } else if (temp[i] > temp[j]) {
                    nums[p] = temp[j++];
                } else {
                    nums[p] = temp[i++];
                }
            }
            System.out.println("nums = " + Arrays.toString(nums));
        }
    }

    static class Merge {

        // 用于辅助合并有序数组
        private static int[] temp;

        public static void sort(int[] nums) {
            // 先给辅助数组开辟内存空间
            temp = new int[nums.length];
            // 排序整个数组（原地修改）
            sort(nums, 0, nums.length - 1);
        }

        // 定义：将子数组 nums[lo..hi] 进行排序
        private static void sort(int[] nums, int lo, int hi) {
            if (lo == hi) {
                // 单个元素不用排序
                return;
            }
            // 这样写是为了防止溢出，效果等同于 (hi + lo) / 2
            int mid = lo + (hi - lo) / 2;
            // 先对左半部分数组 nums[lo..mid] 排序
            sort(nums, lo, mid);
            // 再对右半部分数组 nums[mid+1..hi] 排序
            sort(nums, mid + 1, hi);
            // 将两部分有序数组合并成一个有序数组
            merge(nums, lo, mid, hi);
        }

        // 将 nums[lo..mid] 和 nums[mid+1..hi] 这两个有序数组合并成一个有序数组
        private static void merge(int[] nums, int lo, int mid, int hi) {
            // 先把 nums[lo..hi] 复制到辅助数组中
            // 以便合并后的结果能够直接存入 nums
            for (int i = lo; i <= hi; i++) {
                temp[i] = nums[i];
            }

            // 数组双指针技巧，合并两个有序数组
            int i = lo, j = mid + 1;
            for (int p = lo; p <= hi; p++) {
                if (i == mid + 1) {
                    // 左半边数组已全部被合并
                    nums[p] = temp[j++];
                } else if (j == hi + 1) {
                    // 右半边数组已全部被合并
                    nums[p] = temp[i++];
                } else if (temp[i] > temp[j]) {
                    nums[p] = temp[j++];
                } else {
                    nums[p] = temp[i++];
                }
            }
        }
    }

}