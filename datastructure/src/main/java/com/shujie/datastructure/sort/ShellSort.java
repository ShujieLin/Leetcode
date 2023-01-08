package com.shujie.datastructure.sort;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort(arr);
//        shellSort2(arr);
//        shellSort3(arr);
        shellSort4(arr);
    }

    private static void shellSort4(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始，逐个进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int insertValue = arr[i];//保存当前元素的数值
                int insertIndex = i;//保存当前元素的下标
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {//循环进行移动
                    arr[insertIndex] = arr[insertIndex - gap];//当前数的前面一位数挪到当前数
                    insertIndex -= gap;//指针往前挪gap位
                }
                //退出循环，说明找到了插入的位置
                arr[insertIndex] = insertValue;
            }
            System.out.println("arr = " + Arrays.toString(arr));
        }
    }

    /**
     *
     * 移位法，效率有大量的提升
     * 思路：
     * 第一轮：从第2个数开始，和第1个数进行比较，假如小于第1个的数，则把前第1个数往后面挪动一位，指针往前挪一位，指向null，退出循环。当前指针的后一位作为插入的位置
     * 第二轮：从第3个数开始，和第2个数进行比较，假如小于第2个的数，则把前第2个数往后面挪动一位，指针往前挪一位，指向第1个数。
     * 第3个数继续和指针指向的第1个数比较，假如小于第1个数，把第1个数继续往挪1位，指针往前挪一位，指向null，退出循环。当前指针的后一位作为插入的位置
     * 依次类推。。。
     *
     * @param arr
     */
    private static void shellSort3(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始，逐个进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int insertValue = arr[i];//保存当前元素的数值
                int insertIndex = i - gap;//保存当前元素的前一个元素的下标
                while (insertIndex >= 0 && insertValue < arr[insertIndex]) {//循环进行移动
                    arr[insertIndex + gap] = arr[insertIndex];//当前数往后挪一位
                    insertIndex -= gap;//指针往前挪index位
                }
                //退出循环，说明找到了插入的位置
                arr[insertIndex + gap] = insertValue;
            }
            System.out.println("arr = " + Arrays.toString(arr));
        }
    }


    /**
     * 交换法，每次对比，假如符合条件都需要进行交换，效率较低
     *
     * @param arr
     */
    private static void shellSort2(int[] arr) {
        int temp = 0;

        //步长：5，,2，,1，,0.5，
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {//间隔每次除以二，直到不能大于/等于1
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("arr = " + Arrays.toString(arr));
        }

    }

    private static void shellSort(int[] arr) {
        int temp = 0;

        //第一轮，把10个数据分为5组
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                System.out.println("分5组：i = " + i + " j = " + j);
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));

        //第一轮，把10个数据分为2组
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
                System.out.println("分2组：i = " + i + " j = " + j);
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));

        //第3轮，把10个数据分为1组
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println("分1组：i = " + i + " j = " + j);
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }


}
