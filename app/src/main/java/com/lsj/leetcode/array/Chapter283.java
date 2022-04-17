package com.lsj.leetcode.array;

/**
 * @Description:
 * @Author: linshujie
 * @Date: 2022/1/25
 */
public class Chapter283 {
    public static void main(String[] args) {

        int[] num = {0,2,3,50,0,0,0,5,3,2,2};
        moveZeroes2(num);
    }

    public static void moveZeroes2(int[] nums) {
        //指针下标，用于记录所有的非零元素
        int indexNonZore = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[indexNonZore ++] = nums[i];
            }
        }

        for (int i = indexNonZore; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int i :
                nums) {
            System.out.println(i + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null)
            return;

        //非零数组的下标，用于保存非零的数据
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }

        //把剩余的数据填充
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
