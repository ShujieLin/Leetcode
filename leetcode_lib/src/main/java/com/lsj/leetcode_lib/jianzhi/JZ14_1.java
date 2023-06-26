package com.lsj.leetcode_lib.jianzhi;

/**
 * File description
 *
 * @author linshujie
 * @date 6/26/2023
 */
public class JZ14_1 {
    public static void main(String[] args) {
        int i = new Solution().cuttingRope(10);
        System.out.println("i = " + i);
    }

    static class Solution {
        private int[] memo;
        public int cuttingRope(int n) {
            memo = new int[n + 1];
            return dp(n);
        }

        private int dp(int n) {
            if (n == 2) return 1;
            if (memo[n] > 0) return memo[n];
            int res = 0;
            //每次减去1，直到减到已知的子问题
            for (int i = 1; i < n; i++) {
                //i * dp(n - i)
                //不知道dp(n - i)大，还是i * (n - i)大
                int multipy = i *  Math.max((n - i), dp(n - i));
                res = Math.max(res, multipy);
            }
            memo[n] = res;
            return res;
        }
    }
}