package com.lsj.leetcode_lib.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linshujie
 */
public class JZ079 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        List<List<Integer>> subsets = new Solution().subsets(nums);
        for (List<Integer> list :
                subsets) {
            System.out.println("subsets.toArray() = " + Arrays.toString(list.toArray()));
        }
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backStrack(res, new ArrayList<>(), nums, 0);
            return res;
        }

        private void backStrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int start) {
            res.add(new ArrayList<>(cur));
            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                //System.out.println("nums[" + i + "] = " + nums[i]);
                backStrack(res, cur, nums, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
