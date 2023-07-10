package com.lsj.leetcode_lib.jianzhi;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class JZ21 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};

        int[] empty = new int[0];
        int[] exchange = new Solution().exchange(empty);
        System.out.println("Arrays.toString(exchange) = " + Arrays.toString(exchange));
    }

    static class Solution {
        public int[] exchange(int[] nums) {
/*
            if (nums == null || nums.length == 0) return null;
*/
            if (nums == null) return null;

            int fast = 0, slow = 0;
            //快慢指针，fast遇到奇数，和slow指向的元素进行交互，slow++。循环
            while (fast < nums.length) {
                if (nums[fast] % 2 != 0) {
                    int temp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = temp;
                    slow++;
                }
                fast++;
            }
            return nums;
        }
    }

}