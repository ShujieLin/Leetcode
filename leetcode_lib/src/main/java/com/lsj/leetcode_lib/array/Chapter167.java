package com.lsj.leetcode_lib.array;

/**
 * @description:
 * @date: 2022/2/10
 * @author: linshujie
 */
public class Chapter167 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 17;
        Solution.twoSum(numbers,target);
    }

    static class Solution {
        public static int[] twoSum(int[] numbers, int target) {
            int leftIndex = 0,rightIndex = numbers.length - 1;
            int[] result = new int[2];
            while (leftIndex < rightIndex){
                int sum = numbers[leftIndex] + numbers[rightIndex];
                if (sum == target){
                    result = new int[]{leftIndex + 1, rightIndex + 1};
                    break;
                }else if (sum < target){
                    leftIndex ++;
                }else {
                    rightIndex --;
                }
            }
            for (int i :
                    result) {
                System.out.println(i);
            }
            return result;
        }
    }
}
