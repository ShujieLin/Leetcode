package com.lsj.leetcode_lib.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linshujie
 */
public class JZ083 {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = new Solution().permute(nums);
        for (List<Integer> list :
                permute) {
            System.out.println("p = " + Arrays.toString(list.toArray()));
        }
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backStack(res,new ArrayList<>(),nums);
            return res;
        }

        private void backStack(List<List<Integer>> res, List<Integer> cur, int[] nums) {

            if (cur.size() == nums.length){
                res.add(new ArrayList<>(cur));
            }

            for (int i = 0; i < nums.length; i++) {
                if (!cur.contains(nums[i])){//做判断
                    cur.add(nums[i]);
                    backStack(res, cur, nums);
                    cur.remove(cur.size() - 1);
                }

            }
        }
    }
}
