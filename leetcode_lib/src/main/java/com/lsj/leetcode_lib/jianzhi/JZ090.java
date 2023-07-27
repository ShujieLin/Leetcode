package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ090 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        int[] nums2 = new int[]{1,2,3,1};
        int[] nums3 = new int[]{0};
        int rob = new Solution().rob(nums3);
        System.out.println("rob = " + rob);
    }

    static class Solution {
        public int rob(int[] nums) {

            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            //动态规划

            //dp 第一个偷
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = dp[0];//第二个不能偷
            //转移方程 最后一个不能偷
            for (int i = 2; i < nums.length - 1; i++) {
                //dp[i]代表可以偷盗的最大金额
                //偷：dp[i] = dp[i - 2] + nums[i]
                //不偷：dp[i] = dp[i-1]
                //每次更新最大值
                //Math.max{dp[i - 2] + num[i] , dp[i - 1]}
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            System.out.println("dp[nums.length - 2] = " + dp[nums.length - 2]);

            //第一个不偷
            int[] dp2 = new int[nums.length];
            dp2[0] = 0;
            dp2[1] = nums[1];//第二个偷
            for (int i = 2; i < nums.length; i++) {
                dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
            }
            System.out.println("dp2[nums.length - 1] = " + dp2[nums.length - 1]);

            return Math.max(dp2[nums.length - 1], dp[nums.length - 2]);
        }
    }
}
