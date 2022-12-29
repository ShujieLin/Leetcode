package com.shujie.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author: linshujie
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        bubbleSort(arr);

        int[] arr2 = {10, 20, 3, 4, 5};
        bubbleSort2(arr2);
    }

    private static void bubbleSort(int[] arr) {
        int temp;

        for (int i = 0; i < arr.length - 1; i++) {//第一层循环仅仅用于标记第几轮的排序，需要进行n - 1轮排序，5个数字的数组，则需要4次排序
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("arr = " + Arrays.toString(arr));
        }
    }

    /**
     * 假如一次排序都没进行，则跳出for循环
     * @param arr
     */
    private static void bubbleSort2(int[] arr) {
        int temp;

        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {//第一层循环仅仅用于标记第几轮的排序，需要进行n - 1轮排序，5个数字的数组，则需要4次排序
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
            System.out.println("arr2 = " + Arrays.toString(arr));
        }
    }
}