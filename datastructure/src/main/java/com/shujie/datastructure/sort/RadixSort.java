package com.shujie.datastructure.sort;

/**
 * 基数排序
 * @author: linshujie
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3,542,748,14,214};
    }

    /**
     *
     * @param arr
     */
    public  static void radixSort(int[] arr){
        //第一轮，针对每个元素的个位进行排序处理
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中每次放入的数据个数。
        int[] bucketElementCounts = new int[10];

        for (int j = 0; j < arr.length; j++) {
            //每个元素个位的值
            int digitOfElement = arr[j] % 10;

            //放入对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

    }

}
 