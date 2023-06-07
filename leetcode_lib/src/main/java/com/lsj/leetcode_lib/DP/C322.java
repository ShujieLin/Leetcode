package com.lsj.leetcode_lib.DP;

import java.util.Arrays;

/**
 * @author linshujie
 */
public class C322 {
    public static void main(String[] args) {
        int i = new Solution1().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("i = " + i);
        int i1 = new MySolution1().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("i1 = " + i1);

        int i2 = new MySolution2().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("i2 = " + i2);

    }

    /**
     * 空判断
     * 遍历金币数组，递归调用，以（当前amount - 当前金币）和金币集合作为参数
     */
    static class MySolution1 {
        int coinChange(int[] coins, int amount) {
            return dp(coins, amount);
        }

        private int dp(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;

            int res = Integer.MAX_VALUE;
            //自底向上方法
            for (int coin :
                    coins) {
                int count = dp(coins, amount - coin);
                if (count == -1) continue;
                res = Math.min(count + 1, res);
            }
            if (res == Integer.MAX_VALUE) {
                return -1;
            }
            return res;
        }
    }

    /**
     * 空判断
     * 遍历金币数组，递归调用，以（当前amount - 当前金币）和金币集合作为参数
     */
    static class MySolution2 {
        int coinChange(int[] coins, int amount) {
            int[] memo = new int[amount + 1];//备忘录，记录每次dp的结果，防止重复计算
            Arrays.fill(memo, 666);
            return dp(coins, amount, memo);
        }

        private int dp(int[] coins, int amount, int[] memo) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;

            //表示计算过
            if (memo[amount] != 666) return memo[amount];

            int res = Integer.MAX_VALUE;
            //自底向上方法
            for (int coin :
                    coins) {
                int count = dp(coins, amount - coin, memo);
                if (count == -1) continue;
                res = Math.min(count + 1, res);
            }

            res = res == Integer.MAX_VALUE ? -1 : res;
            memo[amount] = res;
            return res;
        }
    }

    /**
     * 空判断
     * 遍历金币数组，递归调用，以（当前amount - 当前金币）和金币集合作为参数
     */
    static class MySolution3 {

        private int[] memo;

        int coinChange(int[] coins, int amount) {
            //备忘录，记录每次dp的结果，防止重复计算
            memo = new int[amount + 1];
            Arrays.fill(memo, 666);
            return dp(coins, amount);
        }

        private int dp(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;

            //表示计算过
            if (memo[amount] != 666) return memo[amount];

            int res = Integer.MAX_VALUE;
            //自底向上方法
            for (int coin :
                    coins) {
                int count = dp(coins, amount - coin);
                if (count == -1) continue;
                res = Math.min(count + 1, res);
            }

            res = res == Integer.MAX_VALUE ? -1 : res;
            memo[amount] = res;
            return res;
        }
    }

    static class MySolution4 {
        private int[] memo;

        int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;

            int[] dp = new int[amount + 1];
            for (int i = 0; i <= amount; i++) {
                for (int coin :
                        coins) {
                    if (dp[i] == -1) continue;
                }
            }
        }
    }

    static class Solution1 {
        int coinChange(int[] coins, int amount) {
            // 题目要求的最终结果是 dp(amount)
            return dp(coins, amount);
        }

        // 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
        int dp(int[] coins, int amount) {
            System.out.println("-> amount = " + amount);
            // base case
            if (amount == 0) return 0;
            if (amount < 0) return -1;

            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 计算子问题的结果
                int subProblem = dp(coins, amount - coin);
                // 子问题无解则跳过
                if (subProblem == -1) continue;
                // 在子问题中选择最优解，然后加一
                res = Math.min(res, subProblem + 1);
            }
            int result = res == Integer.MAX_VALUE ? -1 : res;
            System.out.println("<- result = " + result);
            return result;
        }
    }

    static class Solution2 {
        int[] memo;

        int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            // 备忘录初始化为一个不会被取到的特殊值，代表还未被计算
            Arrays.fill(memo, -666);

            return dp(coins, amount);
        }

        int dp(int[] coins, int amount) {
            System.out.println("-> amount : " + amount);
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            // 查备忘录，防止重复计算
            if (memo[amount] != -666)
                return memo[amount];

            int minCount = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 计算子问题的结果
                int subProblem = dp(coins, amount - coin);
                // 子问题无解则跳过
                if (subProblem == -1) continue;
                // 在子问题中选择最优解，然后加一
                minCount = Math.min(minCount, subProblem + 1);
                System.out.println("minCount = " + minCount);
                /*System.out.println("subProblem = " + subProblem);*/
            }
            // 把计算结果存入备忘录
            memo[amount] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
            System.out.println("<- memo[" + amount + "] : " + memo[amount]);
            return memo[amount];
        }
    }


    static class Solution3{
        int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 数组大小为 amount + 1，初始值也为 amount + 1
            Arrays.fill(dp, amount + 1);

            // base case
            dp[0] = 0;
            // 外层 for 循环在遍历所有状态的所有取值
            for (int i = 0; i < dp.length; i++) {
                // 内层 for 循环在求所有选择的最小值
                for (int coin : coins) {
                    // 子问题无解，跳过
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return (dp[amount] == amount + 1) ? -1 : dp[amount];
        }

    }
}