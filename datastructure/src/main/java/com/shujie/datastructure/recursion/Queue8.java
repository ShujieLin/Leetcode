package com.shujie.datastructure.recursion;

/**
 * 八皇后问题：
 * 是一个回溯算法的典型案例
 * 在8x8的国际象棋上摆放八个皇后，使其不能相互攻击。
 * 即任意两个皇后都不能处于同一行、同一列、同一斜线上，有多少种摆法
 * <p>
 * 思路：
 * 使用一维数组，下标表示八个皇后的第几个，每个下标的值表示皇后摆放的位置
 * example：{0,4,7,5,2,6,1,3} 表示第一个皇后在第1列，第二个皇后在第5列，第三个皇后在第8列
 *
 * @author: linshujie
 */
public class Queue8 {
    int max = 8;
    int[] array = new int[max];//下标表示第几个皇后（对应棋盘第几行），下标对应的值表示棋盘的第几列
    int count;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.putQueue(0);
        System.out.println("queue8.count = " + queue8.count);
    }

    /**
     * 编写一个方法，摆放第n个皇后
     */
    private void putQueue(int n) {
        if (n == max) {//n == 8的时候皇后已经放好
            print();
            count ++;
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //把当前皇后n放到该行的第i列
            array[n] = i;
            if (judge(n)) {//假如判断不会相互攻击
                //摆放第n+1个皇后
                putQueue(n + 1);
            }
        }
    }

    /**
     * 判断当前皇后和后续所有的皇后是否相互攻击
     * 思路：
     * 1.同一行或者同一列会攻击
     * 2.同一斜线会攻击
     * 由于使用一维数组的下标表示每个皇后，遍历数组的时候，遍历的变量"i"不会重复，所以"行"不需要单独判断行
     * <p>
     * example：
     * {0,4,7,5,2,6,1,3}
     * 假如n = 0 表示第一个皇后 ，array[0] = 0,表示第一个皇后在第一列
     * 那么该皇后坐标 = {0，0}，当i = 0，表示在同一行，return false,i++
     * i = 1，判断array[0] 和 array[1]是否在同一行，同一列，同一对斜线，
     * 首先i在不断累加，直接得知不在同一行。需要判断是否在同一列：array[0] == array[1]
     * 是否在同一斜线，只需要判断两个坐标的横竖坐标的绝对值是否相等：abs[1-0] = abs[array[1]] - abs[array[0]]
     *
     * @param n 第几个皇后
     * @return
     */
    private boolean judge(int n) {
        if (n < 0 || n >= max) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < n; i++) {//i = n+1 也可以？
            if (array[i] == array[n] ||
                    Math.abs(i - n) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }




    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
