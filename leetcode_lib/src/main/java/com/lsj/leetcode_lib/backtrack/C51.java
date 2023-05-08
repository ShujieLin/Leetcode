package com.lsj.leetcode_lib.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: linshujie
 */
public class C51 {

    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }

    static class Solution {

        private List<List<String>> res;

        public List<List<String>> solveNQueens(int n) {
            res = new ArrayList<>();
            List<String> board = new ArrayList<>();

            //添加空棋盘
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(".");
                }
                board.add(sb.toString());
            }
            System.out.println("Arrays.toString(board) = " + Arrays.toString(board.toArray()));

            //回溯寻找可行的下棋路径
            backStack(board, 0);

            return res;
        }

        /**
         * 选择列表
         * 前进
         * 后退
         * 触底
         *
         * @param board
         * @param row
         */
        private void backStack(List<String> board, int row) {
            int n = board.size();

            System.out.println("row = " + row);
            //触底
            if (board.size() /*- 1*/ == row) {
                res.add(new ArrayList<>(board));
                System.out.println("触底 ");
                return;
            }

            for (int column = 0; column < n; column++) {
                if (!isValid(board, row, column)) continue;

                //前进
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(column, 'Q');
                board.set(row, sb.toString());
                System.out.println(Arrays.toString(board.toArray()));


                backStack(board,row + 1 );//不能使用自增，自增的话在回溯的时候无法回复该函数栈的原本row，导致错误

                //回退
                sb.setCharAt(column, '.');
                board.set(row, sb.toString());
            }

        }

        /**
         * 这一步棋能不能下
         *
         * @param board
         * @param row
         * @param column
         * @return
         */
        private boolean isValid(List<String> board, int row, int column) {
            //判断该列的上面的每一行是否存在皇后
            for (int i = 0; i <= row/*假如当前有皇后也不行*/; i++) {
                if (board.get(i).charAt(column) == 'Q') return false;
            }

            //判断左上是否有皇后
            for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') return false;
            }

            //判断右上是否有皇后
            for (int i = row, j = column; i >= 0 && j < board.size(); i--, j++) {
                if (board.get(i).charAt(j) == 'Q') return false;
            }
            return true;
        }
    }

    // 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 cpp 代码对比查看。
    static class Solution2 {
        List<List<String>> res = new ArrayList<>();

        /* 输入棋盘边长 n，返回所有合法的放置 */
        public List<List<String>> solveNQueens(int n) {
            // '.' 表示空，'Q' 表示皇后，初始化空棋盘
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append('.');
                }
                board.add(sb.toString());
            }
            backtrack(board, 0);
            return res;
        }

        // 路径：board 中小于 row 的那些行都已经成功放置了皇后
        // 选择列表：第 row 行的所有列都是放置皇后的选择
        // 结束条件：row 超过 board 的最后一行
        void backtrack(List<String> board, int row) {
            // 触发结束条件
            if (row == board.size()) {
                res.add(new ArrayList<>(board));
                System.out.println(" 触底 ");
                return;
            }

            int n = board.get(row).length();
            for (int col = 0; col < n; col++) {
                // 排除不合法选择
                if (!isValid(board, row, col)) {
                    continue;
                }
                // 做选择
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());
                System.out.println("--> " + sb);

                // 进入下一行决策
                backtrack(board, row + 1);
                // 撤销选择
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
                System.out.println(" <-- " + sb);
            }
        }

        /* 是否可以在 board[row][col] 放置皇后？ */
        boolean isValid(List<String> board, int row, int col) {
            int n = board.size();

            System.out.println(Arrays.toString(board.toArray()));
            /* 检查列是否有皇后互相冲突 */
            for (int i = 0; i < n; i++) {
                if (board.get(i).charAt(col) == 'Q') {
                    return false;
                }
            }

            /* 检查右上方是否有皇后互相冲突 */
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }

            /* 检查左上方是否有皇后互相冲突 */
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }

            return true;
        }
    }

}
