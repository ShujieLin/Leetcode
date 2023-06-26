package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ10_1 {
    public static void main(String[] args) {
        int fib = new Solution2().fib(1);
        System.out.println("fib = " + fib);
    }

    static class Solution2 {
        public int fib(int n) {
            if (n == 0 ) return 0;
            if (n == 1) return 1;
            int mod = 1000000007;
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            }
            return dp[n];
        }
    }

    static class Solution {
        private int[] memo;
        private static final int mod = 1000000007;
        public int fib(int n) {
            memo = new int[n + 1];
            return dp(n);
        }

        private int dp(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (memo[n] != 0) return memo[n];
            int res = dp(n - 1) + dp(n - 2);
            res = res % mod;
            memo[n] = res;
            return res;
        }
    }
}
