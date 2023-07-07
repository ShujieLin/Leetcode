package com.lsj.leetcode_lib.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: linshujie
 */
public class JZ061 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,7,11};
        int[] nums2 = new int[]{2,4,6};
        new Solution2().kSmallestPairs(nums1,nums2,3);
    }

    static class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for (int i1 : nums1) {
                List<Integer> list = new ArrayList<>();
                list.add(i1);
                for (int i2 : nums2) {
                    list.add(i2);
                    res.add(list);
                }
            }

            return res;
        }
    }


    static class Solution2 {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            // 存储三元组 (num1[i], nums2[i], i)
            // i 记录 nums2 元素的索引位置，用于生成下一个节点
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                // 按照数对的元素和升序排序
                return (a[0] + a[1]) - (b[0] + b[1]);
            });
            // 按照 23 题的逻辑初始化优先级队列
            for (int i = 0; i < nums1.length; i++) {
                pq.offer(new int[]{nums1[i], nums2[0], 0});
            }

            for (int[] array :pq) {
                System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
            }

            List<List<Integer>> res = new ArrayList<>();
            // 执行合并多个有序链表的逻辑
            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                System.out.println("Arrays.toString(cur) = " + Arrays.toString(cur));
                k--;
                // 链表中的下一个节点加入优先级队列
                int next_index = cur[2] + 1;
                if (next_index < nums2.length) {
                    System.out.println("next_index = " + Arrays.toString(new int[]{cur[0], nums2[next_index], next_index}));
                    pq.add(new int[]{cur[0], nums2[next_index], next_index});
                }

                List<Integer> pair = new ArrayList<>();
                pair.add(cur[0]);
                pair.add(cur[1]);
                System.out.println("add: cur[0] = " + cur[0] + " cur[1] = " + cur[1]);
                res.add(pair);
            }
            return res;
        }
    }
}
