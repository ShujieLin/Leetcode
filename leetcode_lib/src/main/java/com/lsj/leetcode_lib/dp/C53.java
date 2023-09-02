package com.lsj.leetcode_lib.dp;

/**
 * @author linshujie
 */
public class C53 {
    public static void main(String[] args) {
        int[] n = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = new MySolution().maxSubArray(n);
        System.out.println("i = " + i);
    }

    static class MySolution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            int[] dp = new int[n];
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                //状态转移方程
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            }

            //遍历，找出最大值
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }


    static class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            int[] dp = new int[n];
            // base case
            // 第一个元素前面没有子数组
            dp[0] = nums[0];
            // 状态转移方程
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            }
            // 得到 nums 的最大子数组
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
// 详细解析参见：
// https://labuladong.github.io/article/?qno=53

}
