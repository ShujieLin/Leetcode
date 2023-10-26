package com.shujie.hot100.subArray;

/**
 * 前缀和（Prefix Sum）是一种在计算中经常使用的技巧，用于有效地计算数组中某一范围内元素的和。前缀和的基本思想是创建一个新的数组，其中每个元素表示原始数组中前若干个元素的累加和。
 * 前缀和的优势：以(o1)的时间复杂度得到某块区间的总和。
 * 假设有一个数组 `arr`，前缀和数组 `prefixSum` 的第 `i` 个元素 `prefixSum[i]` 表示原数组 `arr` 中前 `i` 个元素的和。具体而言，`prefixSum[i]` 等于 `arr[0] + arr[1] + ... + arr[i]`。
 *
 * 使用前缀和的好处是，在计算任意区间 `[left, right]` 内元素的和时，你只需要执行一次减法操作，即 `prefixSum[right] - prefixSum[left - 1]`（注意要处理 `left` 为0的情况）。
 * 这比遍历区间内的元素并逐个相加要高效得多，尤其在需要多次查询不同区间和的情况下。
 *
 * 前缀和在处理数组或序列的部分和问题（如子数组和、区间和、累积和）非常有用，常见的应用包括解决子数组和等于特定值的问题，以及在一维和二维数组中进行区间和的快速查询。
 * @author linshujie
 */
public class PrefixSum {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;

        prefixSum(arr, n);
    }

    private static void prefixSum(int[] arr, int n) {
        // 创建一个数组来存储前缀和
        int[] prefixSum = new int[n];

        // 计算前缀和并存储在prefixSum数组中
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // 输出前缀和数组
        System.out.println("Prefix Sum Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(prefixSum[i] + " ");
        }
    }
}
