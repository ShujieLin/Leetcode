package com.lsj.leetcode_lib.dp;

/**
 * @author: linshujie
 */
public class C416 {

    public static void main(String[] args) {
        boolean b = new MySolution().canPartition(new int[]{1, 5, 11, 5});
        System.out.println("b = " + b);
    }

    static class MySolution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            //假如总数不能被2整除，一定存在答案
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;

            int n = nums.length;
            boolean[][] dp = new boolean[n+1][sum+1];
            //容量为0，代表可以装满
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }
            sum = sum / 2;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {
                    //看下是否可以装得下
                    if (j - nums[i - 1] < 0){
                        //装不下，取上一个值
                        dp[i][j] = dp[i - 1][j];
                    }else {
                        //装得下，取或者不取
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }

            return dp[n][sum];
        }
    }

    static class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) sum += num;
            // 和为奇数时，不可能划分成两个和相等的集合
            if (sum % 2 != 0) return false;
            int n = nums.length;
            sum = sum / 2;
            boolean[][] dp = new boolean[n + 1][sum + 1];
            // base case
            for (int i = 0; i <= n; i++)
                dp[i][0] = true;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (j - nums[i - 1] < 0) {
                        // 背包容量不足，不能装入第 i 个物品
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 装入或不装入背包
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[n][sum];
        }
    }
// 详细解析参见：
// https://labuladong.github.io/article/?qno=416

}
