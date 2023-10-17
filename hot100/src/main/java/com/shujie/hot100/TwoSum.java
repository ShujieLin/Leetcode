package com.shujie.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linshujie
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { /*3,2,4*/3, 3/*2, 7, 11, 15*/ };
        int target = /*9*/6;
        int[] ints = new Solution().twoSum(nums, target);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.containsKey(target - nums[i])){
                    return new int[]{hashMap.get(target - nums[i]),i};
                }
                hashMap.put(nums[i],i);
            }
            return  new int[]{};
        }
    }

    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; ++i) {
                if (hashtable.containsKey(target - nums[i])) {//
                    return new int[]{hashtable.get(target - nums[i]), i};
                }
                hashtable.put(nums[i], i);
            }
            return new int[0];
        }
    }

    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/two-sum/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
