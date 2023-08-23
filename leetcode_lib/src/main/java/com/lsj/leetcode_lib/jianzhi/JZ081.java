package com.lsj.leetcode_lib.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linshujie
 */
public class JZ081 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = new Solution().combinationSum(candidates, target);
        for (List<Integer> l :
                lists) {
            System.out.println("l.toArray() = " + Arrays.toString(l.toArray()));
        }
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            List<List<Integer>> res = new ArrayList<>();

            backStack(res, new ArrayList<Integer>() {}, candidates, target, 0);
            return res;
        }

        private void backStack(List<List<Integer>> res, ArrayList<Integer> cur,
                int[] candidates, int target, int start) {
            int sum = 0;
            for (int i = 0; i < cur.size(); i++) {
                sum += cur.get(i);
            }
            System.out.println("sum = " + sum);

            if (sum == target) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (sum < target){
                    cur.add(candidates[i]);
                    backStack(res, cur, candidates, target, i );
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}