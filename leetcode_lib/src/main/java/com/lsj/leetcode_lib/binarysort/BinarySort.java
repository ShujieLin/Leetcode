package com.lsj.leetcode_lib.binarysort;

/**
 * @author linshujie
 */
public class BinarySort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 7};

        System.out.println("二分模板2:");
        System.out.println("范围内，存在 " + binarySearch(nums,3) + "");
        System.out.println("范围内，不存在 " + binarySearch(nums,4) + "");
        System.out.println("范围左边，不存在 "  + binarySearch(nums,-1) + "");
        System.out.println("范围右边，不存在 " + binarySearch(nums,10) + "");

        System.out.println("找到重复target的左边界:");
        System.out.println("范围内，存在 " + findRepetTargetLeftBound2(nums,3) + "");
        System.out.println("范围内，不存在 " + findRepetTargetLeftBound2(nums,4) + "");
        System.out.println("范围左边，不存在 "  + findRepetTargetLeftBound2(nums,-1) + "");
        System.out.println("范围右边，不存在 " + findRepetTargetLeftBound2(nums,10) + "");

        System.out.println("找到重复target的右边界:");
        System.out.println("范围内，存在 " + findRepetTargetRightBound2(nums,3) + "");
        System.out.println("范围内，不存在 " + findRepetTargetRightBound2(nums,4) + "");
        System.out.println("范围左边，不存在 "  + findRepetTargetRightBound2(nums,-1) + "");
        System.out.println("范围右边，不存在 " + findRepetTargetRightBound2(nums,10) + "");
    }

    /**
     * 搜索target的时候，当low == high，收缩右边界，如果找不到的话，high = arr.length
     */
    public static int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        //假如target大于arr内的所有元素，left = arr.length
        //假如target小于arr内的所有元素，left = 0
        //假如target在arr元素范围内，但是不存在，left等于大于target的第一位
        return low;
    }

    private static int findRepetTargetLeftBound(int[] arr, int target) {
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
        //假如target大于arr内的所有元素，left = arr.length
        //假如target小于arr内的所有元素，left = 0
        //假如target在arr元素范围内，但是不存在，那么left = target下标 + 1
        return left;
    }

    private static int findRepetTargetLeftBound2(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        //假如target大于arr内的所有元素，left = arr.length
        //假如target小于arr内的所有元素，left = 0
        //假如target在arr元素范围内，但是不存在，那么left = target下标 + 1
        return left;
    }

    private static int findRepetTargetRightBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target){
                left = left + 1;
            }else if (arr[mid] < target){
                left = left + 1;
            }else {
                right = mid;
            }
        }
        //假如target大于arr内的所有元素，left = arr.length - 1
        //假如target小于arr内的所有元素，left = -1
        //假如target在arr元素范围内，但是不存在，那么left = target下标 + 1
        return left - 1;
    }

    /**
     * 搜索右边界，arr[mid] == target的时候左边界右移一位，假如target<left，相当于left = 0没有动过；
     * @param arr
     * @param target
     * @return
     */
    private static int findRepetTargetRightBound2(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target){
                left = left + 1;
            }else {
                right = mid;
            }
        }
        //假如target大于arr内的所有元素，left = arr.length - 1
        //假如target小于arr内的所有元素，left = -1
        return left - 1;
    }
}