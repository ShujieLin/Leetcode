package com.shujie.datastructure.recursion;

/**
 * 迷宫问题
 *
 * @author: linshujie
 */
public class Maze {
    public static void main(String[] args) {
        int rows = 8;
        int columns = 7;
        //画一个地图，8行7列,1表示墙
        int[][] map = new int[rows][columns];
        //建立左右墙体
        for (int i = 0; i < rows; i++) {
            map[i][0] = 1;
            map[i][columns - 1] = 1;
        }

        //建立上下墙体
        for (int i = 0; i < columns; i++) {
            map[0][i] = 1;
            map[rows - 1][i] = 1;
        }

        //添加两个坐标{1,3}{2,3}
        map[3][1] = 1;
        map[3][2] = 1;

        for (int[] ints : map) {
            System.out.print("\n");
            for (int anInt : ints) {
                System.out.printf("%d   ", anInt);
            }
        }
        System.out.println("\n开始走迷宫----------------");

        //起点为（1，,1），终点为（row - 2，column - 2）

        setWay(map, 1, 1);
        for (int[] ints : map) {
            System.out.print("\n");
            for (int anInt : ints) {
                System.out.printf("%d   ", anInt);
            }
        }
        System.out.println("结束----------------");

    }

    /**
     * 走出迷宫
     * 规则：
     * "1" = 墙体，不能走
     * "0" = 路，可以走
     * "2" = 走过的路,能走通
     * "3" = 验证过了是走不通的点
     *
     * @param map    地图
     * @param row    开始找的行
     * @param column 开始找的列
     */
    private static boolean setWay(int[][] map, int row, int column) {
        //设置终点
        int endRow = 6;
        int endColumn = 5;
        if (map[endRow][endColumn] == 2) {//已经找到
            return true;
        } else {
            //只有值为0的路可以走
            if (map[row][column] == 0) {
                map[row][column] = 2;//假设该路可以走通
                if (setWay(map, row + 1, column)) {//下
                    return true;//递归之后，假如结果为true，则这里return true，进入下一个判断继续递归，直到最后，确定所有递归都找到不到终点，返回false
                } else if (setWay(map, row, column + 1)) {//右
                    return true;
                } else if (setWay(map, row - 1, column)) {//上
                    return true;
                } else if (setWay(map, row, column - 1)) {//左
                    return true;
                } else {//找不到终点
                    map[row][column] = 3;//尚未找到，标记为3
                    return false;
                }
            } else {//地图点可能为1，,2，,3
                return false;
            }
        }
    }
}
