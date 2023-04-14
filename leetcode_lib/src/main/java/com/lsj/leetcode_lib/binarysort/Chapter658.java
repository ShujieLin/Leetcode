package com.lsj.leetcode_lib.binarysort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linshujie
 */
public class Chapter658 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        int x = 5;
        int k = 2;

        new Solution().findClosestElements(nums, k, x);
    }

    static class Solution {

        /**
         * 1 <= k <= arr.length
         * 1 <= arr.length <= 104
         * arr 按 升序 排列
         * -104 <= arr[i], x <= 104
         *
         * @param arr
         * @param k
         * @param x
         * @return
         */
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            //二分法找到最接近target的值
            //arr中存在target的时候，直接可找到target的下标
            //arr中不存在target的时候，返回返回的下标是比target大一个位置的下标
            //所以分为两半的话：[first,left] [right last]
            int right = findTarget(arr, x);
            int left = right - 1;
            System.out.println("left = " + left);
            System.out.println("right = " + right);
            while (k-- > 0){
                if ((x - arr[left]) <= (arr[right] - x)){
                    left --;
                }else {
                    right ++;
                }
            }
            System.out.println("left = " + left );
            System.out.println("right = " + right);
            return null;
        }

        private int findTarget(int[] arr, int target) {
            int left = 0, right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }
            return left;
        }
    }
}
