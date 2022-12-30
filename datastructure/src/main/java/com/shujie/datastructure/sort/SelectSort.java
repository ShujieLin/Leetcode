package com.shujie.datastructure.sort;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{101,34,119,1};
        selectSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    /**
     * 思路：
     * 每一轮遍历一次数组，对比第n个元素和后续所有元素，找到最小值，把最小值和当前交换。
     * @param arr
     */
    private static void selectSortDrill(int[] arr) {

        //假设为最小值
        int minIndex = 0;
        int min = arr[0];

        for (int j = 0 + 1; j < arr.length; j++) {
            if (min > arr[j]){
                min = arr[j];
                minIndex = j;
            }
        }
        //把min存放到arr[0]
        arr[minIndex] = arr[0];
        arr[0] = min;
    }

    /**
     * 思路：
     * 1.每一轮遍历一次数组，对比第i个元素和后续所有元素，找到最小值，把最小值和当前交换。
     * 2.进入下一次遍历，n大小的数组，需要n-1次遍历
     * @param arr
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //假设为最小值
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            //把min存放到arr[0]
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}