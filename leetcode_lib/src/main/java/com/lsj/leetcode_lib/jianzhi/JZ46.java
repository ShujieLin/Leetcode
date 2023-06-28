package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ46 {
    public static void main(String[] args) {
        int i = new Solution().translateNum(12258);
        System.out.println("i = " + i);
    }

    static class Solution {
        public int translateNum(int num) {
            return dp(num);
        }

        private int dp(int num) {
            String s = String.valueOf(num);
            int n = s.length();
            int[] dp = new int[n + 1];
            //base case
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i < dp.length; i++) {
                char c = s.charAt(i - 1), d = s.charAt(i - 2);
                //单个数字组成字母
                if (c >= '0' && c <= '9') {
                    dp[i] = dp[i - 1] + dp[i];
                }
                //两个数字组成一个字母
                if (d == '1' || d == '2' && c <= '5') {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
            return dp[n];
        }
    }

    static class Solution2 {
        public int translateNum(int num) {
            String s = num + "";
            int n = s.length();
            if (n < 1) {
                return 0;
            }
            // 定义：dp[i] 表示 s[0..i-1] 的解码方式数量
            int[] dp = new int[n + 1];
            // base case: s 为空或者 s 只有一个字符的情况
            dp[0] = 1;
            dp[1] = 1;

            // 注意 dp 数组和 s 之间的索引偏移一位
            for (int i = 2; i <= n; i++) {
                char c = s.charAt(i - 1), d = s.charAt(i - 2);
                if ('0' <= c && c <= '9') {
                    // 1. s[i] 本身可以作为一个字母
                    dp[i] += dp[i - 1];
                }
                if (d == '1' || d == '2' && c <= '5') {
                    // 2. s[i] 和 s[i - 1] 结合起来表示一个字母
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }
    }
}
