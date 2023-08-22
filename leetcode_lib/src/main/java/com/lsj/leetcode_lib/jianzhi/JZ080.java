package com.lsj.leetcode_lib.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linshujie
 */
public class JZ080 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = new Solution().combine(n, k);
        for (List<Integer> list:
        combine){
            System.out.println("list = " + Arrays.toString(list.toArray()));
        }
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            stackBack(res, new ArrayList<>(), n, k, 1);
            return res;
        }

        private void stackBack(List<List<Integer>> res, ArrayList<Integer> cur, int n, int k,
                int start) {
            if (cur.size() == k) {
                res.add(new ArrayList<>(cur));
                return;
            }

            for (int i = start; i <= n; i++) {
                cur.add(i);//选择
                stackBack(res, cur, n, k, i + 1);//路径
                cur.remove(cur.size() - 1);//取消选择
            }
        }
    }
}
