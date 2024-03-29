package com.lsj.leetcode_lib.tree.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author linshujie
 */
public class C1091 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1}, {1, 0}};
        int[][] grid2 = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int bfs = new Solution().shortestPathBinaryMatrix(grid2);
        System.out.println("bfs = " + bfs);
    }

    static class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            return bfs2(grid);
        }

        private int bfs2(int[][] grid) {
            int depth = 1;
            int targetRow = grid.length - 1,
                    targetColumn = grid.length - 1;

            Queue<int[]> queue = new LinkedList<>();
            /*Set<int[]> visited = new HashSet<>();*/
            boolean[][] visited = new boolean[grid.length][grid.length];

            queue.offer(new int[]{0, 0});
            visited[0][0] = true;

            //添加八个方向
            int[][] dir = new int[][]{{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int __ = 0; __ < size; __++) {
                    int[] cur = queue.poll();
                    int row = cur[0];
                    int cloumn = cur[1];

                    if (grid[row][cloumn] == 1) continue;

                    if (row == targetRow &&
                            cloumn == targetColumn &&
                            grid[row][cloumn] == 0)
                        return depth;

                    for (int i = 0; i < dir.length; i++) {
                        int nextRow = row + dir[i][0];
                        int nextCloumn = cloumn + dir[i][1];
                        System.out.println("nextRow = " + nextRow + " nextCloumn = " + nextCloumn);

                        if (nextRow >= 0 && nextRow < grid.length &&
                                nextCloumn >= 0 && nextCloumn < grid.length &&
                                !visited[nextRow][nextCloumn] &&
                                grid[nextRow][nextCloumn] == 0) {
                            System.out.println("move forward " );
                            queue.offer(new int[]{nextRow, nextCloumn});
                            visited[nextRow][nextCloumn] = true;
                        }
                    }
                }
                depth++;
            }
            return -1;
        }


        private int bfs(int[][] grid) {
            int depth = 1;
            int targetX = grid.length - 1,
                    targetY = grid.length - 1;

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();

                    if (grid[cur[0]][cur[1]] == 1) continue;

                    if (cur[0] == targetX && cur[1] == targetY && grid[cur[0]][cur[1]] == 0)
                        return depth;

                    int[] down = moveDown(cur[0], cur[1]);
                    if (down[0] <= targetX && down[1] <= targetY && grid[down[0]][down[1]] == 0) {
                        queue.offer(down);
                    }

                    int[] right = moveRight(cur[0], cur[1]);
                    if (right[0] <= targetX && right[1] <= targetY && grid[right[0]][right[1]] == 0) {
                        queue.offer(right);
                    }

                    int[] xie = moveXie(cur[0], cur[1]);
                    if (xie[0] <= targetX && xie[1] <= targetY && grid[xie[0]][xie[1]] == 0) {
                        queue.offer(xie);
                    }

                }
                depth++;
            }


            return -1;
        }

        /**
         * 0 left
         * 1 right
         */
        private int[] moveRight(int x, int y) {
            return new int[]{x + 1, y};
        }

        private int[] moveDown(int x, int y) {
            return new int[]{x, y + 1};
        }

        private int[] moveXie(int x, int y) {
            return new int[]{x + 1, y + 1};
        }

    }


    class Solution0 {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
                return -1;
            }

            Queue<int[]> q = new LinkedList<>();
            // 需要记录走过的路径，避免死循环
            boolean[][] visited = new boolean[m][n];

            // 初始化队列，从 (0, 0) 出发
            q.offer(new int[]{0, 0});
            visited[0][0] = true;
            int pathLen = 1;

            // 执行 BFS 算法框架，从值为 0 的坐标开始向八个方向扩散
            int[][] dirs = new int[][]{
                    {0, 1}, {0, -1}, {1, 0}, {-1, 0},
                    {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
            };
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int __ = 0; __ < sz; __++) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];
                    if (x == m - 1 && y == n - 1) {
                        return pathLen;
                    }
                    // 向八个方向扩散
                    for (int i = 0; i < 8; i++) {
                        int nextX = x + dirs[i][0];
                        int nextY = y + dirs[i][1];
                        // 确保相邻的这个坐标没有越界且值为 0 且之前没有走过
                        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                                && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                            q.offer(new int[]{nextX, nextY});
                            visited[nextX][nextY] = true;
                        }
                    }
                }
                pathLen++;
            }
            return -1;
        }
    }
}