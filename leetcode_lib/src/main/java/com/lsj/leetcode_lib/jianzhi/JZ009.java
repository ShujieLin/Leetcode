package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ009 {
    public static void main(String[] args) {
        /*int[] nums = new int[] { 10, 5, 2, 6 };
        int k = 100;*/
        int[] nums = new int[] { 10, 5, 2, 6 };
        int k = 0;
        int i = new Solution().numSubarrayProductLessThanK(nums, k);
        System.out.println("i = " + i);
    }

    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int left = 0, right = 0;
            int product = 1;
            int res = 0;
            while (right < nums.length) {
                product *= nums[right];

                while (product >= k && left <= right) {
                    product /= nums[left];
                    left++;
                }
                System.out.println(
                        "left = " + left + " right = " + right + " product = " + product);
                res += right - left + 1;
                right++;
            }

            return res;
        }

        public int numSubarrayProductLessThanK3(int[] nums, int k) {
            int left = 0, right = 0;
            int product = 1;
            int res = 0;
            while (right < nums.length) {
                product *= nums[right];

                while (product >= k && left <= right) {
                    product /= nums[left];
                    left++;
                }

                res += right - left + 1;

                right++;
            }

            return res;
        }

        public int numSubarrayProductLessThanK2(int[] nums, int k) {
            if (k <= 1) {
                return 0;
            }

            int start = 0;
            int product = 1;
            int count = 0;

            for (int end = 0; end < nums.length; end++) {
                product *= nums[end];

                while (product >= k) {
                    product /= nums[start];
                    start++;
                }
                //以r为结尾，子数组必须包含nums[r]这个数，因此存在
                //nums[r]
                //nums[r], nums[r - 1]
                //nums[r], nums[r - 2]
                //nums[r], nums[r - 2]... , nums[l]
                //即 r - l + 1个符合条件的子数组
                count += end - start + 1;
                System.out.println("start = "
                        + start
                        + " end = "
                        + end
                        + " product = "
                        + product
                        + " count = "
                        + (end - start + 1));
            }

            return count;
        }
    }
}
