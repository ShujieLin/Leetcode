package com.lsj.leetcode_lib.DP;

import java.util.Arrays;

/**
 * @author linshujie
 */
public class C300 {
    public static void main(String[] args) {
        /*new Solution().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});*/
        int lengthOfLIS = new MySolution().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        System.out.println("lengthOfLIS = " + lengthOfLIS);


    }

    static class MySolution {

        public int lengthOfLIS(int[] nums) {

            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        System.out.println(" dp[" + i + "] = " + dp[i] + " dp[" + j + "] = " + (dp[j] + 1));
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int res = 0;
            //遍历一次，找出dp中的最大值
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }

    static class Solution {
        int lengthOfLIS(int[] nums) {
            // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
            int[] dp = new int[nums.length];
            // base case：dp 数组全都初始化为 1
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                System.out.println("i = " + i);
                for (int j = 0; j < i; j++) {
                    System.out.println("j = " + j);
                    if (nums[i] > nums[j]) {
                        System.out.println(" dp[" + i + "] = " + dp[i] + " dp[" + j + "] = " + (dp[j] + 1));
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
