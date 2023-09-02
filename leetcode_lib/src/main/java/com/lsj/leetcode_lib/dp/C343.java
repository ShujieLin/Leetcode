package com.lsj.leetcode_lib.dp;

import java.util.Arrays;

/**
 * File description
 *
 * @author linshujie
 * @date 6/19/2023
 */
public class C343 {
    public static void main(String[] args) {
        int i = new Solution3().integerBreak(3);
        System.out.println("i = " + i);
    }

    static class Solution3 {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.println("i = " + i + " j = " + j);
                    int multiply = Math.max((i - j), dp[i - j]) * j;
                    System.out.println("multiply = " + multiply);
                    dp[i] = Math.max(multiply, dp[i]);
                    System.out.println("dp = " + dp[i]);
                }
            }

            System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
            return dp[n];
        }
    }

    static class Solution {
        private int[] mem;
        public int integerBreak(int n) {
            mem = new int[n + 1];
            return dp(n);
        }

        /**
         * n >= 2
         */
        private int dp(int n) {
            if (mem[n] != 0) return mem[n];
            System.out.println(" -> n = " + n);
            int res = 0;
            for (int i = 1; i <= n; i++) {
                System.out.println(i + " * " + (n - i));
                int multiply = i * Math.max((n - i), dp(n - i));
                res = Math.max(res, multiply);
            }
            mem[n] = res;
            System.out.println("< - return res = " + res);
            return res;
        }
    }

    /**
     * integerBreak(4)
     * = max(1 * 3, 1 * integerBreak(3), 2 * 2, 2 * integerBreak(2))
     */
    static class Solution2 {
        int[] memo;

        public int integerBreak(int n) {
            memo = new int[n + 1];
            return dp(n);
        }

        // 定义：拆分 n 获得的最大乘积为 dp(n),n >= 2
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
                int multiply = i * Math.max(dp(n - i), n - i);
                res = Math.max(res, multiply);
            }
            memo[n] = res;
            return res;
        }
    }
}