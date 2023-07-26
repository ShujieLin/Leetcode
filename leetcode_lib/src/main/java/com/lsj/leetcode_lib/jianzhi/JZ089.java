package com.lsj.leetcode_lib.jianzhi;

/**
 * @author linshujie
 */
public class JZ089 {
    public static void main(String[] args) {

        /*int[] nums = new int[]{1,2,3,1};
        int rob = new Solution().rob(nums);*/

        int[] nums = new int[] { 2, 7, 9, 3, 1 };
        int[] nums2 = new int[] { 1, 1 };
        int rob = new Solution().rob(nums2);
        System.out.println("rob = " + rob);
    }

    static class Solution {
        /**
         * 这是一个经典的动态规划问题，可以使用动态规划来解决。下面是解题的思路：
         *
         * 定义一个长度为n的数组dp，其中dp[i]表示在第i个房屋时能够偷窃到的最高金额。
         *
         * 边界情况：当只有一个房屋时，最高金额即为该房屋的金额，即dp[0] = nums[0]。
         *
         * 状态转移方程：对于第i个房屋，可以选择偷窃或不偷窃。
         *
         * 如果选择偷窃第i个房屋，则最高金额为dp[i-2] + nums[i]，因为选择偷窃第i个房屋时，不能偷窃第i-1个房屋。
         * 如果选择不偷窃第i个房屋，则最高金额为dp[i-1]，因为不偷窃第i个房屋时，可以偷窃第i-1个房屋。
         * 综上所述，可以得到状态转移方程：
         * dp[i] = max(dp[i-2] + nums[i], dp[i-1])
         *
         * 最终的最高金额为dp[n-1]，其中n为房屋的数量。
         */
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int[] dp = new int[nums.length];
            //边界
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                //状态转移，最大值：
                // 选择：nums[i] + dp[i - 2]
                // 不选择： dp[i - 1]
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
                System.out.println("dp = " + dp[i]);
            }
            return dp[nums.length - 1];
        }
    }
}