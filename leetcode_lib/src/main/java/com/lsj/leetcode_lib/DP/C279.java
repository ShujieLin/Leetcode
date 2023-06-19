package com.lsj.leetcode_lib.DP;

import java.util.Arrays;

/**
 * File description
 *
 * @author linshujie
 * @date 6/19/2023
 */
public class C279 {
    public static void main(String[] args) {
        new Solution().numSquares(12);
    }

    static class Solution {
        public int numSquares(int n) {
            //dp[i]对应的结果值
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            //base case
            dp[0] = 0;

            //状态转移
            for (int i = 1; i <= n; i++) {
                System.out.println("-> i = " + i);
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                    System.out.println("dp[" + i + "] = " + dp[i]);
                }
            }
            System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
            return dp[n];
        }
    }

    static class Solution2 {
        public int numSquares(int n) {
            // 定义：和为 i 的平方数的最小数量是 dp[i]
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            // base case
            dp[0] = 0;
            // 状态转移方程
            for (int i = 1; i <= n; i++) {
                System.out.println(" -> ");
                for (int j = 1; j * j <= i; j++) {
                    // i - j * j 只要再加一个平方数 j * j 即可凑出 i
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                    System.out.println("dp[" + i + "] = " + dp[i]);
                }
            }

            System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
            return dp[n];
        }
    }
}
