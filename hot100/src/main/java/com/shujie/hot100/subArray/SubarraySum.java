package com.shujie.hot100.subArray;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * @author linshujie
 */
public class SubarraySum {
    public static void main(String[] args) {

    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int prefix = 0;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(0, 1);//key = 前缀和， value = 前缀和的出现的次数
            for (int i = 0; i < nums.length; i++) {
                prefix += nums[i];

                //检查哈希表中是否存在键prefix - k，如果存在，说明之前的前缀和中有某个子数组的和等于k - prefix，这意味着从那个子数组到当前
                //位置的子数组和为k。因此，将count增加哈希表中键为pre - k的值。
                if (hashMap.containsKey(prefix - k)){
                    count += hashMap.get(prefix - k);
                }
                //存储每个prefix及其数量到hashmap中
                hashMap.put(prefix,hashMap.getOrDefault(prefix,0) + 1);
            }
            return count;
        }
    }

    public class Solution2 {
        public int subarraySum(int[] nums, int k) {
            int count = 0/*用于计数符合条件的子数组个数。*/, pre =
                    0/*用于记录当前的和，初始化为0，表示从数组开头开始累加*/;
            HashMap<Integer, Integer> mp = new HashMap<>();//和为键，出现次数为值
            mp.put(0, 1);//在哈希表mp中，首先将键0和值1放入，表示前缀和为0出现了1次。
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];//在每次迭代中，更新前缀和pre，将其累加当前元素nums[i]。

                //检查哈希表中是否存在键pre - k，如果存在，说明之前的前缀和中有某个子数组的和等于k - pre，这意味着从那个子数组到当前
                //位置的子数组和为k。因此，将count增加哈希表中键为pre - k的值。
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);//将当前前缀和pre添加到哈希表中
            }
            return count;
        }
    }

    /*作者：力扣官方题解
    链接：https://leetcode.cn/problems/subarray-sum-equals-k/description/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}