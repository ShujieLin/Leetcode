package com.lsj.leetcode_lib.jianzhi;

/**
 * File description
 *
 * @author linshujie
 * @date 6/26/2023
 */
public class JZ10_2 {

    public static void main(String[] args) {
        int i = new Solution1().numWays(7);
        System.out.println("i = " + i);
    }

    static class Solution1 {
        private static final int mod = 1000000007;

        public int numWays(int n) {
            if (n == 0) return 1;
            if (n == 1) return 1;
            if (n == 2) return 2;

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            }
            return dp[n];
        }
    }

    static class Solution2 {
        private static final int mod = 1000000007;
        private int[] memo;
        public int numWays(int n) {
            memo = new int[n + 1];
            return dp(n);
        }

        private int dp(int n) {
            if (n == 0 ) return 1;
            if (n == 1) return 1;
            if (n == 2) return 2;
            if (memo[n] > 0) return memo[n];
            memo[n] = (dp(n - 1) + dp(n - 2)) % mod;
            return memo[n];
        }
    }

    static class Solution3 {
        // 备忘录
        int[] memo;

        public int numWays(int n) {
            memo = new int[n + 1];
            return dp(n);
        }

        // 定义：爬到第 n 级台阶的方法个数为 dp(n)
        int dp(int n) {
            // base case
            if (n <= 2) {
                return n;
            }
            if (memo[n] > 0) {
                return memo[n];
            }
            // 状态转移方程：
            // 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
            memo[n] = dp(n - 1) + dp(n - 2);
            return memo[n];
        }
    }
}
