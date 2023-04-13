package com.lsj.leetcode_lib.binarysort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linshujie
 */
public class Chapter658 {
    public static void main(String[] args) {
        int[] nums = new int[]{1/*, 2, 4, 6, 7*/};
        int x = 2;
        int k = 4;

        List<Integer> closestElements = new Solution().findClosestElements(nums, k, -11);
        System.out.println("closestElements = " + closestElements);

    }

    static class Solution {
        /**
         * x可能不存在与数组中
         *
         * @param arr
         * @param k
         * @param x
         * @return
         */
        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            int left = findLeftIndex(arr, x);
            System.out.println("left = " + left);
            int right = findRightIndex(arr, x);
            System.out.println("right = " + right);
            if (left == -1) ++left;
            if (right == arr.length) --right;

            for (int i = 0; i < k; i++) {
                //左边差距小
                if ((x - arr[left]) <= (arr[right] - x)) {
                    --left;
                }else {
                    ++right;
                }
            }

            List<Integer> list = new ArrayList<>();
            for (int i = left; i < right; i++) {

                list.add(arr[i]);
            }

            return list;
        }

        /**
         * 搜索右边区域的左边界
         *
         * @param arr
         * @param target
         * @return
         */
        private int findRightIndex(int[] arr, int target) {
            int left = 0, right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    right = mid;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            //如果没有找到左边界
            if (left == arr.length) {
                return left;
            }
            //如果找到了
            if (arr[left] == target) {
                return left + 1;
            } else {
                return left;
            }
        }

        /**
         * 查找左边部分的右边界
         *
         * @param arr
         * @param target
         * @return
         */
        private int findLeftIndex(int[] arr, int target) {
            int left = 0, right = arr.length;
            while (left < right) {//结束条件：left == right
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    //收缩左边界
                    left = mid + 1;
                } else if (arr[mid] < target) {
                    //收缩左边界
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int bound = left - 1;

            //假如没有找到右边界
            if (bound == -1) {
                return bound;
            }
            //假如找到target，向左移动一位
            if (arr[bound] == target) {
                return bound - 1;
            } else {
                return bound;
            }
        }


    }
}
