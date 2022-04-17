package com.lsj.leetcode_lib.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 *
 *
 * @Author: linshujie
 * @Date: 2022/1/25
 */
public class Chapter498 {
    public static void main(String[] args) {

        int[][] testMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] testMatrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] result = findDiagonalOrder(testMatrix);
        for (int i :
                result) {
            System.out.println(i);
        }
    }

    public static  int[] findDiagonalOrder( int[][] matrix) {
        if (matrix.length == 0 || matrix == null){
            return new int[0];
        }

        //行数
        final int N = matrix.length;
        //列数
        final int M = matrix[0].length;
        //对角线的数量
        final int lineSum = M + N - 1;

        //用于盛放排序后的数组元素，便于后面进行翻转操作
        List<Integer> intermediate = new ArrayList();

        //用于记录新建的数组的下标
        int k = 0;
        //用于记录新数组
        int[] resultArray = new int[N * M];

        for (int d = 0; d < lineSum; d++) {
            //每次都清空数组listNewArray
            intermediate.clear();

            //获取每条对角线的起点
            int row = d < M ? 0 : d + 1 - M;
            int col = d < M ? d : M - 1;

            //从右往左开始记录每条对角线的数据
            while (row < N && col > -1){
                intermediate.add(matrix[row][col]);
                row ++;
                col --;
//                ++row;
//                --col;
            }

            //对于排在偶数的对角线进行反转操作
            if (d % 2 == 0){
                Collections.reverse(intermediate);
            }

            //记录把元素填充到新的数组中
            for (int i = 0; i < intermediate.size(); i++) {
                resultArray[k++] = intermediate.get(i);
            }
        }
        return resultArray;
    }
}

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N*M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < N && c > -1) {

                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }
}
