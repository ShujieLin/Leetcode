package com.lsj.leetcode_lib.queue;

/**
 * @date: 2022/4/17
 * @author: linshujie
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Chapter200 {
    public static void main(String[] args) {


        char[][] grid = {{'1','0'},{'0','1'}};
        Chapter200 chapter200 = new Chapter200();
        int newIslands = chapter200.newIslands(grid);
        System.out.println(newIslands);
    }

    public int newIslands(char[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        //行数
        int nr = grid.length;
        //列数
        int nc = grid[0].length;
        //标记
        int numLenght = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1'){
                    numLenght ++;
                    //深度搜索附近相连的1，并全部标记为0
                    dfs(grid,r,c);
                }
            }
        }
        return numLenght;
    }

    /**
     * 深度优先搜索
     * @param grid
     * @param r
     * @param c
     */
    private void dfs(char[][] grid, int r, int c) {
        //行数
        int nr = grid.length;
        //列数
        int nc = grid[0].length;
        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == '0'){
            return;
        }

        //找到1，将其标记为0，证明查找过
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
