package com.shujie.datastructure.sort;

import java.util.Arrays;

/**
 * 快速排序：
 * 是对冒泡排序的改进。
 * 基本思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小。
 * 然后再按照此方法对这两部分分别进行快速排序，整个过程递归进行
 *
 * @author: linshujie
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{78, -9, 0, -567, 70, 23,-199,388,2,1,112,445,12};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        //创建临时左右指针变量。防止原本参数被改，后面需要使用原始参数进行递归
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];//中轴的值
        int temp;
        while (l < r) {
            while (arr[l] < pivot) {//说明当前左边的排序是正确的
                l++;
            }

            while (arr[r] > pivot) {//说明当前右边的排序是正确的
                r--;
            }

            //说明中轴左边的值全部小于中轴的值，右边的值全部大于中轴的值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换完之后发现arr[l]==pivot，r前移动一位
            if (arr[l] == pivot) {
                r--;
            }
            //交换完之后发现arr[r]==pivot，l后移动一位
            if (arr[r] == pivot) {
                l++;
            }
        }

        //递归进行
        //退出递归的条件
        if (l == r) {
            l++;
            r--;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
