package com.lsj.leetcode_lib.tree.BST;

/**
 * @author linshujie
 */
public class Chapter96 {

    public static void main(String[] args) {
        int i = new Solution().numTrees(1);
        System.out.println("i = " + i);
    }

    static class Solution {
        int[][] memo;

        public int numTrees(int n) {
            memo = new int[n + 1][n + 1];//不能设置为n吗？
            return traverse(1, n);
        }

        private int traverse(int low, int high) {
            if (low > high) return 1;//当传递进去的low和high相等，就是只有一个情况
            if (memo[low][high] != 0) {
                return memo[low][high];
            }
            int res = 0;
            for (int i = low; i <= high; i++) {
                //以i为root，进行递归
                int left = traverse(low, i - 1);
                int right = traverse(i + 1, high);
                res += left * right;
            }
            memo[low][high] = res;
            return res;
        }
    }
}