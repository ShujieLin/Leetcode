package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ04 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        new Solution().findNumberIn2DArray(matrix, 5);
    }

    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int row = matrix.length;
            int column = matrix[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = column; j > 0; j--) {
                    if (matrix[i][j] > target) {

                    }
                }
            }
            return true;
        }
    }
}
