package com.lsj.leetcode_lib.jianzhi;

/**
 * @author linshujie
 */
public class JZ091 {
    public static void main(String[] args) {

        int[][] consts = new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };

        int[][] consts2 = new int[][] { { 3, 5, 3 }, { 6, 17, 6 }, { 7, 13, 18 }, { 9, 10, 18 } };
        int minCost = new Solution2().minCost(consts2);
        System.out.println("minCost = " + minCost);
    }

    static class Solution2 {
        public int minCost(int[][] costs) {
            //房子数量
            int n = costs.length;

            //dp
            int[][] dp = new int[n][3];

            //base case
            dp[0][0] = costs[0][0];
            dp[0][1] = costs[0][1];
            dp[0][2] = costs[0][2];

            //状态转移
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
            }

            return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        }
    }

    static class Solution {
        public int minCost(int[][] costs) {
            //房子数量
            int n = costs.length;
            //状态转移
            //第n个的时候，最大值
            int[] dp = new int[n];
            dp[0] = Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
            //dp[1] = Math.min(Math.min(costs[1][0], costs[1][1]), costs[1][2]);

            int lastColor;
            for (int i = 1; i < n; i++) {
                int[] cur = costs[i];

                //添加判断条件，使得相邻的房子颜色不同
                int min = Math.min(Math.min(cur[0], cur[1]), cur[2]);

                for (int j = 0; j < 2; j++) {
                    if (min == cur[j]) {
                        lastColor = j;
                    }
                }

                dp[i] = dp[i - 1] + min;

                System.out.println("dp[" + i + "] = " + dp[i]);
            }

            return dp[n - 1];
        }
    }
}
