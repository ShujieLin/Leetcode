package com.lsj.leetcode_lib.array;

/**
 * @Description:
 * @Author: linshujie
 * @Date: 2022/1/25
 */
public class Chapter2402 {
    public static void main(String[] args) {
        int[][] testMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] testMatrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(testMatrix2);
//        testI();
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrixNew = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrixNew[col][n - row - 1] = matrix[row][col];
            }
        }

        for (int i = 0; i < matrixNew.length; i++) {
            for (int j = 0; j < matrixNew[i].length; j++) {
                System.out.println(matrixNew[i][j]);
                matrix[i][j] = matrixNew[i][j];
            }
        }
    }
}
