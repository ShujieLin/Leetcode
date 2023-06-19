package com.lsj.leetcode_lib.DP;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class C221 {
    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        new Solution().maximalSquare(matrix);
    }

    static class Solution {
        public int maximalSquare(char[][] matrix) {

            //备忘录,矩阵对应正方形最大值
            int[][] dp = new int[matrix.length][matrix[0].length];

            //base case
            for (int i = 0; i < matrix.length; i++) {
                dp[i][0] = matrix[i][0] - '0';
            }
            for (int i = 0; i < matrix[0].length; i++) {
                dp[0][i] = matrix[0][i] - '0';
            }


            for (int[] array : dp) {
                System.out.println("base case dp = " + Arrays.toString(array));
            }

            //状态转移
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    //找到右下角为1的格子
                    if (matrix[i][j] == '0') continue;
                    dp[i][j] =
                            Math.min(Math.min( dp[i][j - 1], dp[i - 1][j]),
                                    dp[i - 1][j - 1]) + 1;
                }
            }

            for (int[] array : dp) {
                System.out.println("after opration dp = " + Arrays.toString(array));
            }

            int res = 0;
            for (int[] ints : dp) {
                for (int j = 0; j < dp[0].length; j++) {
                    res = Math.max(res, ints[j]);
                }
            }
            System.out.println("res = " + res);
            return res * res;
        }
    }

    static class Solution2 {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            // 定义：以 matrix[i][j] 为右下角元素的全为 1 正方形矩阵的最大边长为 dp[i][j]。
            int[][] dp = new int[m][n];

            // base case，第一行和第一列的正方形边长
            for (int i = 0; i < m; i++) {
                dp[i][0] = matrix[i][0] - '0';
                /*System.out.println("matrix[i][0] = " + matrix[i][0]);
                System.out.println("dp[i][0] = " + dp[i][0]);*/
            }
            for (int j = 0; j < n; j++) {
                dp[0][j] = matrix[0][j] - '0';
            }

            // 进行状态转移
            for (int i = 1; i < m; i++) {
                System.out.println("-> i = " + i);
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == '0') {
                        // 值为 0 不可能是正方形的右下角
                        continue;
                    }
                    System.out.println("j = " + j);
                    System.out.println("dp[" + (i - 1) + "][" + j + "] = " + dp[i - 1][j]);
                    System.out.println("dp[" + i + "][" + (j - 1) + "] = " + dp[i][j - 1]);
                    System.out.println(
                            "dp[" + (i - 1) + "][" + (j - 1) + "] = " + dp[i - 1][j - 1]);

                    dp[i][j] = Math.min(Math.min(
                                    dp[i - 1][j],
                                    dp[i][j - 1]),
                            dp[i - 1][j - 1]
                    ) + 1;
                }
            }

            //找出备忘录中的最长边，计算最大面积
            int len = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    len = Math.max(len, dp[i][j]);
                }
            }
            return len * len;
        }
    }
}
