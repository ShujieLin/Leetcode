package com.lsj.leetcode_lib.DP;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class Jianzhi103 {

    public static void main(String[] args) {
        int i = new Solution().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("i = " + i);
    }

    static class Solution {
        int[] memo;
        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            Arrays.fill(memo,-666);
            return dp(coins, amount);
        }

        private int dp(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            if (memo[amount] != -666) return memo[amount];

            int res = Integer.MAX_VALUE;
            for (int coin :
                    coins) {
                int minCount = dp(coins, amount - coin);//假如是小于零，则返回-1
                if (minCount == -1) continue;//假如是-1，则没有必要继续计算下去，直接跳过
                res = Math.min(res, minCount + 1);//出栈的时候才进行数量+1
                memo[amount] = res;
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
