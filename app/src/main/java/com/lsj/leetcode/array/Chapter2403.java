package com.lsj.leetcode.array;

/**
 * @Description:
 * @Author: linshujie
 * @Date: 2022/1/25
 */
public class Chapter2403 {
    public static void main(String[] args) {
        int[][] testMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] testMatrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        setZeroes(testMatrix);
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        //用于标记
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        //标记为零的行和列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        //含有零的行或列，全部赋值为零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
