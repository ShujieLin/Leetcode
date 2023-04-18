package com.lsj.leetcode_lib;

/**
 * @author: linshujie
 */
public class Chapter5 {
    public static void main(String[] args) {
//        String s = "babad";
        String s = "cbbd";

        String palindrome = new Solution().longestPalindrome(s);
        System.out.println("palindrome = " + palindrome);
    }

    static class Solution {
        public String longestPalindrome(String s) {
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                String s1 = find(i, i, s);//奇数回文
                String s2 = find(i, i + 1, s);//偶数回文

                //使用result记录每次的检测，看哪个最长
                result = result.length() > s1.length() ? result : s1;
                result = result.length() > s2.length() ? result : s2;
            }
            return result;
        }

        String find(int left, int right, String s) {
            while ((left >= 0 && right <= s.length() - 1) &&
                    (s.charAt(left) == s.charAt(right))) {
                left--;
                right++;
            }
            //考虑到可能整个字符串就是回文子串，循环检测到左指针检测到index = 0 ，右指针检测到index = length - 1.
            //返回的时候，左右指针均需要回退一步
            return s.substring(left + 1, right);
        }
    }
}