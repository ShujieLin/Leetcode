package com.lsj.leetcode_lib.tree.BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author linshujie
 */
public class C542 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints = new Solution().updateMatrix(mat);
        for (int[] array :
                ints) {
            System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        }
    }

    static class Solution {
        public int[][] updateMatrix(int[][] mat) {
            return bfs(mat);
        }

        private int[][] bfs(int[][] mat) {
            int row = mat.length;
            int column = mat[0].length;
            Queue<int[]> queue = new LinkedList<>();

            //把所有1变为-1
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (mat[i][j] == 1) mat[i][j] = -1;
                        //把所有为零的格子加到队列中,从零开始进行四个方向的扩张
                    else queue.offer(new int[]{i, j});
                }
            }

            //定义四个方向
            int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int __ = 0; __ < size; __++) {
                    int[] cur = queue.poll();
                    int curRow = cur[0];
                    int curColumn = cur[1];

                    //向四个方向拓展判断
                    for (int i = 0; i < dir.length; i++) {
                        int nextRow = curRow + dir[i][0];
                        int nextColumn = curColumn + dir[i][1];
                        if (nextRow >= 0 && nextRow < row &&
                                nextColumn >= 0 && nextColumn < column && mat[nextRow][nextColumn] == -1) {
                            queue.offer(new int[]{nextRow, nextColumn});
                            mat[nextRow][nextColumn] = mat[curRow][curColumn] + 1;
                        }
                    }
                }

            }
            return mat;
        }
    }

    static class Solution2 {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            // 记录答案的结果数组
            int[][] res = new int[m][n];
            // 初始化全部填充特殊值 -1，代表未计算，
            // 待会可以用来判断坐标是否已经计算过，避免重复遍历
            for (int[] row : res) {
                Arrays.fill(row, -1);
            }

            Queue<int[]> q = new LinkedList<>();
            // 初始化队列，把那些值为 0 的坐标放到队列里
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        q.offer(new int[]{i, j});
                        res[i][j] = 0;
                    }
                }
                System.out.println("res = " + Arrays.toString(res[i]));
            }
            // 执行 BFS 算法框架，从值为 0 的坐标开始向四周扩散
            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                // 向四周扩散
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dirs[i][0];
                    int nextY = y + dirs[i][1];
                    // 确保相邻的这个坐标没有越界且之前未被计算过
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                            && res[nextX][nextY] == -1) {
                        q.offer(new int[]{nextX, nextY});
                        // 从 mat[x][y] 走到 mat[nextX][nextY] 需要一步
                        res[nextX][nextY] = res[x][y] + 1;
                        System.out.println("nextX = " + nextX + " nextY = " + nextY + " nextRes = " + res[nextX][nextY]);
                    }
                }
            }

            return res;
        }
    }
}