package com.lsj.leetcode_lib.jianzhi;

/**
 * @author linshujie
 */
public class JZ63 {
    public static void main(String[] args) {
        //int[] nums = new int[]{7,1,5,3,6,4};
        int[] nums = new int[]{7,6,4,3,1};
        int i = new Solution().maxProfit(nums);
        System.out.println("i = " + i);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;

            int minPrice = Integer.MAX_VALUE,maxProfix  = Integer.MIN_VALUE;
            //遍历，每次更新最小价格minPrice，假如当前价格curPrice - 已知的最小价格minPrice > 最大利润maxProfix ，则更新maxProfix
            for (int i = 0; i < prices.length; i++) {
                minPrice = Math.min(prices[i],minPrice);
                if (prices[i] - minPrice > maxProfix){
                    maxProfix = Math.max(maxProfix,prices[i] - minPrice);
                }
            }

            return maxProfix;
        }
    }
}
