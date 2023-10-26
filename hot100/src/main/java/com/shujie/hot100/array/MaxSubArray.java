package com.shujie.hot100.array;

/**
 * @author linshujie
 */
public class MaxSubArray {
    public static void main(String[] args) {

    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0) return 0;
            int n = nums.length;

            //以 nums[i] 为结尾的「最大子数组和」为 dp[i]。
            int[] dp = new int[n];
            dp[0] = nums[0];
            for (int i = 1/*注意，不是以i = 0开头*/; i < n; i++) {
                //最大值有两个选择，nums[i]，或者 nums[i] + 前面的最大子数组和
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }

            //寻找最大值
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }

    class Solution2 {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            //以 nums[i] 为结尾的「最大子数组和」为 dp[i]。
            int[] dp = new int[n];
            // base case
            // 第一个元素前面没有子数组
            dp[0] = nums[0];
            // 状态转移方程
            // dp[i] 有两种「选择」，要么与前面的相邻子数组连接，形成一个和更大的子数组；要么不与前面的子数组连接，自成一派，自己作为一个子数组。
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
}
