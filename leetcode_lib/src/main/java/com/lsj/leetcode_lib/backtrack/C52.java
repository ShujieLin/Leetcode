package com.lsj.leetcode_lib.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linshujie
 */
public class C52 {
    public static void main(String[] args) {
        int i = new Solution().totalNQueens(4);
        System.out.println("i = " + i);
    }

    static class Solution {
        int res = 0;

        public int totalNQueens(int n) {
            //新建一个容器
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(".");
                }
                board.add(sb.toString());
            }
            System.out.println("Arrays.toString(board.toArray()) = " + Arrays.toString(board.toArray()));

            //回溯
            backStack(0, board);
            return res;
        }

        private void backStack(int row, List<String> board) {

            int n = board.size();
            //触底，添加结果
            if (row == n) {
                res++;
                System.out.println(" 触底 " );
                return;
            }

            //回溯
            for (int clomn = 0; clomn < n; clomn++) {
                //判断是否已经跑过
                if (!isValid(board, row, clomn)) continue;

                //前进
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(clomn, 'Q');
                board.set(row, sb.toString());
                System.out.println(" -> " + Arrays.toString(board.toArray()));

                //回溯
                backStack(row + 1, board);

                //后退
                sb.setCharAt(clomn, '.');
                board.set(row, sb.toString());
                System.out.println(" <- " + Arrays.toString(board.toArray()));
            }
        }

        /**
         * 判断这一步棋是否可以下
         *
         * @param board
         * @param row
         * @param clomn
         * @return
         */
        private boolean isValid(List<String> board, int row, int clomn) {
            //判断同一行
            for (int i = 0; i <= row; i++) {
                if (board.get(i).charAt(clomn) == 'Q') return false;
            }

            //判断左上方是否有皇后
            for (int i = row, j = clomn; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') return false;
            }

            //判断右上方是否有皇后
            for (int i = row, j = clomn; i >= 0 && j < board.size(); i--, j++) {
                if (board.get(i).charAt(j) == 'Q') return false;
            }

            return true;
        }
    }
}
