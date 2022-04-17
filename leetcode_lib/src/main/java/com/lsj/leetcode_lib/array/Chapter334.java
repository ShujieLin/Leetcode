package com.lsj.leetcode_lib.array;

/**
 * @description:
 * @date: 2022/2/9
 * @author: linshujie
 */
public class Chapter334 {
    public static void main(String[] args) {
        char[] s = {'h','e','p','l','o','1'};
        Solution.reverseString(s);
        System.out.println(s);
    }

    static class Solution {
        public static void reverseString(char[] s) {
            int left = 0,right = s.length - 1;
            while (left < right){
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left ++;
                right --;
            }
        }
    }
}
