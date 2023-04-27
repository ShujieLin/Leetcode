package com.lsj.leetcode_lib.tree.BST;

/**
 * @author linshujie
 */
public class Chapter96 {

    class Solution {
        public int numTrees(int n) {

            return traverse(1,n);
        }

        private int traverse(int low, int high) {
            if (low > high) return 1;
            for (int i = low; i <= high; i++) {
                //以i为root，进行递归
                traverse(low,i - 1);
                traverse(i+1,high);

            }
            return 0;
        }
    }
}
