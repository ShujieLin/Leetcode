package com.shujie.datastructure.sort;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2,112,4,66,333,-1,-12344532,454656};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    /**
     * 分治+合并
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        //每次递归，进行一次合并
        merge(arr, left, mid, right, temp);
    }

    /**
     * 合并
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左边有序数组的指针
        int j = mid + 1;//右边有序数组的指针
        int t = 0;//指向temp的指针

        //1.把左右两边的数据按照规则填充到temp数组，直到两边的有序序列中的一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        //2.把剩余的数据一边的数据依次全部填充到temp
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }

        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        //3.把temp数组的元素拷贝到arr
        int tempLeft = left;
        t = 0;
        //第1次：tempLeft = 0,right = 1;   tempLeft = 2,right = 3 ...
        //第2次：tempLeft = 0,right = 3; tempLeft = 4,right = 7
        //第3次：tempLeft = 0,right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }

    }

}
