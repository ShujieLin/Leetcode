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
        boolean b = new Solution3().searchMatrix(matrix, 3);
        System.out.println("b = " + b);
    }


    static class Solution3 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            int colomn = matrix[0].length;

            //初始化坐标在右上角
            int i = 0,j = colomn - 1;

            while (i < row && j >= 0) {
                if (matrix[i][j] > target) {
                    System.out.println("i = " + i + " j = " + j + " matrix[i][j]" + matrix[i][j]);
                    j--;
                } else if (matrix[i][j] < target) {
                    System.out.println("i = " + i + " j = " + j + " matrix[i][j]" + matrix[i][j]);
                    i++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int row = matrix.length;
            int column = matrix[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = column - 1; j >= 0; j--) {
                    if (matrix[i][j] > target) {
                        System.out.println("小于 " + matrix[i][j] + " j = " + j);

                    } else if (matrix[i][j] < target) {
                        System.out.println("大于 " + matrix[i][j] + " i = " + i);

                    } else {
                        System.out.println("找到");
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            // 初始化在右上角
            int i = 0, j = n - 1;
            while (i < m && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] < target) {
                    // 需要大一点，往下移动
                    i++;
                } else {
                    // 需要小一点，往左移动
                    j--;
                }
            }
            // while 循环中没有找到，则 target 不存在
            return false;
        }
    }
}
