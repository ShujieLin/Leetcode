package com.lsj.leetcode_lib;

import java.util.Arrays;

/**
 * @author linshujie
 */
public class Chapter344 {
    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        new Solution().reverseString(s);
        System.out.println("s = " + Arrays.toString(s));
    }

    static class Solution {
        /**
         * 左右指针+交换
         * @param s
         */
        public void reverseString(char[] s) {
            int left = 0,right = s.length - 1;
            while (left < right){
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left ++;
                right--;
            }
        }
    }
}
