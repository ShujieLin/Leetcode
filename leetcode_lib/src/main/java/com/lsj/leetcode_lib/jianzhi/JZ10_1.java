package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ10_1 {
    public static void main(String[] args) {
        int fib = new Solution().fib(5);
        System.out.println("fib = " + fib);
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
