package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ098 {
    public static void main(String[] args) {
        int m = 3, n = 7;
        int uniquePaths = new Solution().uniquePaths(m, n);
        System.out.println("uniquePaths = " + uniquePaths);
    }

    static class Solution {
        public int uniquePaths(int m, int n) {

            //dp
            int[][] dp = new int[m - 1][n - 1];
            dp[0][0] = 1;
            dp[0][1] = 1;
            dp[1][0] = 1;
            dp[1][1] = 2;

            //转移方程
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
                }
            }


            return dp[m - 1][n - 1];
        }
    }
}
