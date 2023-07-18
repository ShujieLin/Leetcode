package com.lsj.leetcode_lib.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author linshujie
 */
public class JZ57_2 {

    public static void main(String[] args) {
        int[][] continuousSequence = new Solution2().findContinuousSequence(15);
        for (int i = 0; i < continuousSequence.length; i++) {
            System.out.println("Arrays.toString(continuousSequence[i]) = " + Arrays.toString(
                    continuousSequence[i]));
        }
    }

    static class Solution2 {
        public int[][] findContinuousSequence(int target) {
            List<int[]> res = new ArrayList<>();
            int left = 1, right = 1;
            int sum = 0;
            while (right < target) {
                if (target == sum) {
                    int[] ints = new int[right - left];
                    System.out.println("left = " + left + " right = " + right);
                    for (int i = 0; i < right - left; i++) {
                        ints[i] = left + i;
                    }
                    System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
                    res.add(ints);
                }
                sum = sum + right;
                right++;

                while (sum > target) {
                    sum = sum - left;
                    left++;
                }
            }

            return res.toArray(new int[0][]);
        }
    }


    static class Solution {
        public int[][] findContinuousSequence(int target) {

            int left = 1, right = 1;

            int[] nums = new int[target + 1];
            for (int i = 1; i <= target; i++) {
                nums[i] = i;
                /*System.out.println("i = " + i);*/
            }
            List<List<Integer>> res = new ArrayList<>();
            int sum = 0;
            while (right < target) {
                if (target == sum) {
                    List<Integer> list = new ArrayList<>();
                    for (int i = left; i < right; i++) {
                        list.add(i);
                    }
                    res.add(list);
                }
                sum = nums[right] + sum;
                right++;

                while (sum > target) {
                    sum = sum - nums[left];
                    left++;
                }
            }

            int[][] resArray = new int[res.size()][];
            for (List<Integer> ints :
                    res) {
                System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints.toArray()));
            }

            return null;

        }
    }
}