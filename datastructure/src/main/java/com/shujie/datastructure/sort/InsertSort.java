package com.shujie.datastructure.sort;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};

        insertSort(arr);
//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {

        //第一轮{101,34,119,1} -> {34,101,119,1}

        int insertVal = arr[1];//第二个数作为待插入的数
        int insertIndex = 1 - 1;//和第一个数比较

        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];//第一个数往后挪一位，由于第二个数已经保存，不需要额外处理
            insertIndex --;
        }
        //退出循环，说明找到插入的位置
        arr[insertIndex + 1] = insertVal;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        //第二轮 {34,101,119,1} -> {34,101,119,1}
        insertVal = arr[2];//第3个数作为待插入的数
        insertIndex = 2 - 1;//和第2个数比较

        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];//第一个数往后挪一位，由于第二个数已经保存，不需要额外处理
            insertIndex --;
        }
        //退出循环，说明找到插入的位置
        arr[insertIndex + 1] = insertVal;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        //第三轮 {34,101,119,1} -> {34,101,119,1}
        insertVal = arr[3];//第3个数作为待插入的数
        insertIndex = 3 - 1;//和第2个数比较

        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];//第一个数往后挪一位，由于第二个数已经保存，不需要额外处理
            insertIndex --;
        }
        //退出循环，说明找到插入的位置
        arr[insertIndex + 1] = insertVal;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
