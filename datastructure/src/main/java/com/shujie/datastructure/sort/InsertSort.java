package com.shujie.datastructure.sort;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};

        /*insertSort(arr);*/

        insertSort2(arr);
    }

    /**
     * 思路：
     * 第一轮：从第2个数开始，和第1个数进行比较，假如小于第1个的数，则把前第1个数往后面挪动一位，指针往前挪一位，指向null，退出循环。当前指针的后一位作为插入的位置
     * 第二轮：从第3个数开始，和第2个数进行比较，假如小于第2个的数，则把前第2个数往后面挪动一位，指针往前挪一位，指向第1个数。
     * 第3个数继续和指针指向的第1个数比较，假如小于第1个数，把第1个数继续往挪1位，指针往前挪一位，指向null，退出循环。当前指针的后一位作为插入的位置
     * 依次类推。。。
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {

        //第一轮{101,34,119,1} -> {34,101,119,1}

        int insertVal = arr[1];
        int insertIndex = 1 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex --;
        }
        //推出循环，说明找到插入的位置
        arr[insertIndex + 1] = insertVal;
    }

    /**
     * 思路：
     * 第一轮：从第2个数开始，和第1个数进行比较，假如小于第1个的数，则把前第1个数往后面挪动一位，指针往前挪一位，指向null，退出循环。当前指针的后一位作为插入的位置
     * 第二轮：从第3个数开始，和第2个数进行比较，假如小于第2个的数，则把前第2个数往后面挪动一位，指针往前挪一位，指向第1个数。
     * 第3个数继续和指针指向的第1个数比较，假如小于第1个数，把第1个数继续往挪1位，指针往前挪一位，指向null，退出循环。当前指针的后一位作为插入的位置
     * 依次类推。。。
     *
     * @param arr
     */
    private static void insertSort2(int[] arr) {

        //第一轮{101,34,119,1} -> {34,101,119,1}

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
            //推出循环，说明找到插入的位置
            arr[insertIndex + 1] = insertVal;
            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        }

    }
}
