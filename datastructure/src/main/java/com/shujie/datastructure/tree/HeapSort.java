package com.shujie.datastructure.tree;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author: linshujie
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println("堆排序后：" + Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        /*adjustHeap(arr, 1, arr.length);
        System.out.println("第一次" + Arrays.toString(arr));*/

        //根据需求调整为大顶堆或者小顶堆
        for (int i = arr.length / 2 - 1/*非叶子节点的数量*/; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //将堆顶元素和末尾元素交换，将最大元素沉到数组末端
        //重新调整结构，使其满足定义，然后继续交换堆顶元素和当前元素。
        //反复执行调整+交换步骤，直到整个序列有序。
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0, j);
        }

    }

    /**
     * 将数组（二叉树）调整为大顶堆
     * 例如：{4,6,8,5,9} ,i = 1 -> {4,9,8,5,6} , i = 0 ->{9,6,8,5,4}
     *
     * @param arr    需要调整的数组
     * @param i      非叶子节点在数组中的索引
     * @param lenght 需要调整的元素的数量，每次调整完length会减小
     */
    public static void adjustHeap(int[] arr, int i, int lenght) {
        int temp = arr[i];
        for (int k = i * 2 + 1/*k是i结点的左节点*/; k < lenght; k = k * 2 + 1) {
            //假如左子结点的值小于右子结点的值，让k指向右子节点
            if (k + 1 < lenght && arr[k] < arr[k + 1]) {
                k++;
            }
            //假如子结点大于父结点，把较大者赋值给当前结点
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;//由于从左向右，从下到上开始遍历，可以确保下面没有数据了，所以可以break
            }
        }

        //上面遍历结束后，已经把以i为父结点的树的最大值放到了顶部（局部）
        arr[i] = temp;
    }
}
