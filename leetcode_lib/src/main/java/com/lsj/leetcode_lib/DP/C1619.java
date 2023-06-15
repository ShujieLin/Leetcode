package com.lsj.leetcode_lib.DP;

/**
 * File description
 *
 * @author linshujie
 * @date 6/14/2023
 */
public class C1619 {
    public static void main(String[] args) {
       /* int i = new Solution1().maxResult(new int[] { 1, -1, -2, 4, -7, 3 }, 2);
        System.out.println("i = " + i);*/

        //10,-5,-2,4,0,3
        int i = new Solution1().maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3);
        System.out.println("i = " + i);
    }

    // 第一步，暴力递归解法（超时）
    static class Solution1 {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            return dp(nums, n - 1, k);
        }

        // 定义：到达 nums[p] 所能获得的最大分数是 dp(nums, p)
        // 能跳到 nums[p]，必然是从 nums[p-k..p-1] 中的某个位置跳来的
        // 故状态转移方程为：dp[p] = max(nums[p-k..p-1]) + nums[p]
        int dp(int[] nums, int p, int k) {
            System.out.println(" -> p = " + p + " k = " + k);
            if (p == 0) {
                System.out.println(" <-  p = 0");
                return nums[0];
            }
            if (p < 0) {
                System.out.println(" <- p < 0");
                return Integer.MIN_VALUE;
            }
            // 实现状态转移方程
            int res = Integer.MIN_VALUE;
            for (int i = 1; i <= k; i++) {
                int dpRes = dp(nums, p - i, k);
                System.out.println("i = " + i + " dpRes = " + dpRes + " res = " + res);
                res = Math.max(res, dpRes);
            }
            res += nums[p];
            /*System.out.println(" <- res = " + res + " p = " + p);*/
            System.out.println("<- p = " + p + " res = " + res);
            return res;
        }
    }

    static class Solution {
        public int maxResult(int[] nums, int k) {
            return dp(nums, k, nums.length - 1);
        }

        private int dp(int[] nums, int k, int lastIndex) {
            System.out.println("-> lastIndex = " + lastIndex);
            if (lastIndex == 0) return nums[0];
            if (lastIndex < 0) return Integer.MIN_VALUE;

            int res = Integer.MIN_VALUE;
            //每次跳步范围：[1..k]
            for (int i = 1; i <= k; i++) {
                res = Math.max(res, dp(nums, k, lastIndex - i));
            }
            res += nums[lastIndex];

            System.out.println("<- res = " + res);
            return res;
        }
    }
}
