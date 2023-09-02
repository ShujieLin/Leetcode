package com.lsj.leetcode_lib.dp;

/**
 * 0-1背包
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 *
 * @author linshujie
 * @date 6/12/2023
 */
public class Bag01 {
    public static void main(String[] args) {
        int N = 3;//N 个物品
        int W = 4;//可装载重量为 W 的背包
        int[] wt = new int[] { 2, 1, 3 };//其中第 i 个物品的重量为 wt[i]
        int[] val = new int[] { 4, 2, 3 };//价值为 val[i]
        int knapsack = new Solution().knapsack(W, N, wt, val);
        System.out.println("knapsack = " + knapsack);
    }

    static class Solution {
        int knapsack(int maxWeightOfBag, int numberOfStaff, int[] weightArray, int[] valueList) {
            assert numberOfStaff == weightArray.length;
            // base case 已初始化

            int[][] dp = new int[numberOfStaff + 1][maxWeightOfBag + 1];
            for (int i = 1; i <= numberOfStaff; i++) {
                System.out.println(" --------------- ");
                System.out.println("现有物品数量 = " + i);
                for (int w = 1; w <= maxWeightOfBag; w++) {
                    System.out.println("当前背包总容量 = " + w + " weightArray("+ (i - 1) +") = " + weightArray[i - 1]);
                    if (w - weightArray[i - 1] < 0) {
                        //dp[i][w] 表示：对于前 i 个物品（从 1 开始计数），当前背包的容量为 w 时，这种情况下可以装下的最大价值是 dp[i][w]。
                        dp[i][w] = dp[i - 1][w];//装不下，不装，等于上一次的结果即可
                        System.out.println("放不下 - " /*+ dp[i - 1][w]*/);
                    } else {
                        int now = dp[i - 1][w - weightArray[i - 1]] + valueList[i - 1];
                        int before = dp[i - 1][w];
                        System.out.println("能放下 -> now = " + now + " before = " + before);
                        // 装入或者不装入背包，择优
                        dp[i][w] = Math.max(now,before);
                    }
                }
            }

            return dp[numberOfStaff][maxWeightOfBag];
        }
    }

}
