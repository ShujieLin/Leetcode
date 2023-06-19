package com.lsj.leetcode_lib.DP;

import java.util.Arrays;

/**
 * File description
 *
 * @author linshujie
 * @date 6/19/2023
 */
public class C343 {
    public static void main(String[] args) {
        new Solution().integerBreak(10);
    }

    static class Solution {
        public int integerBreak(int n) {

            //int[] dp = new int[n + 1];
            //Arrays.fill(dp, Integer.MIN_VALUE);
            //
            ////base case
            //dp[2] = 1;

            //状态转移
            for (int i = 2; i <= n; i++) {

                //Math.max()
            }

            //System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
            return 0;
        }
    }

    /**
     * ->
     * integerBreak(4)
     * = max(1 * 3, 1 * integerBreak(3), 2 * 2, 2 * integerBreak(2))
     * = max(
     * 1 * max(3, integerBreak(3)),
     * 1 * max(2, integerBreak(2))
     * )
     *
     * ->
     * int res = Integer.MIN_VALUE;
     * for (int i = 1; i <= n; i++) {
     * res = max(res, i * max(integerBreak(n - i), n - i));
     * }
     */
    static class Solution2 {
        int[] memo;

        public int integerBreak(int n) {
            memo = new int[n + 1];
            return dp(n);
        }

        // 定义：拆分 n 获得的最大乘积为 dp(n)
        int dp(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (memo[n] > 0) {
                return memo[n];
            }

            // 状态转移方程
            int res = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                res = Math.max(res,
                        i * Math.max(dp(n - i), n - i));
            }
            memo[n] = res;
            return res;
        }
    }
}