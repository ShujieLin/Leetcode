package com.shujie.datastructure.sort;

/**
 * @author: linshujie
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);

     /*   int i = 10;
        i -= 5;
        System.out.println("i = " + i);*/
    }

    private static void shellSort(int[] arr) {
        int temp = 0;

        //第一轮，把10个数据分为5组
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]){
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }


        //第一轮，把10个数据分为5组
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]){
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }

        //第一轮，把10个数据分为5组
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }
    }


}
