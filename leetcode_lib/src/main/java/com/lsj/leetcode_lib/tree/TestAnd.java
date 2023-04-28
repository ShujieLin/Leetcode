package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class TestAnd {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 5, 1, 7, 10, 12};

        int p = 0;
        while ( nums[0] < 100 && p < nums.length - 1){
            p++;
            System.out.println("p = " + p);
        }
    }
}
