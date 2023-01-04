package com.shujie.datastructure.sort;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};

        insertSort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {

        //第一轮{101,34,119,1} -> {34,101,119,1} -> {34,101,119,1}

        int insertVal = arr[1];
        int insertIndex = 1 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex --;
        }
        //推出循环，说明找到插入的位置
        arr[insertIndex + 1] = insertVal;



    }


}
