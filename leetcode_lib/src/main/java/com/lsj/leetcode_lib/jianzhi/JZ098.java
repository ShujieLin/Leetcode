package com.lsj.leetcode_lib.jianzhi;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class JZ098 {
    public static void main(String[] args) {
        int m = 7, n = 3;
        int uniquePaths = new Solution().uniquePaths(m, n);
        System.out.println("uniquePaths = " + uniquePaths);
    }

    static class Solution {
        public int uniquePaths(int m, int n) {

            //dp
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            System.out.println("dp = " + Arrays.deepToString(dp));


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