package com.lsj.leetcode_lib.jianzhi;

/**
 * @author: linshujie
 */
public class JZ018 {
    public static void main(String[] args) {
        String s = "naccan";
        String s2 = "OP";
        boolean palindrome = new Solution().isPalindrome(s2);
        System.out.println("palindrome = " + palindrome);
    }

    static class Solution {
        /**
         * 过滤非字母的字符
         * 双指针两边向中间靠拢
         *
         * @param s
         * @return
         */
        public boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    sb.append(Character.toLowerCase(c));
                }
            }
            System.out.println("sb = " + sb);
            int leftP = 0, rightP = sb.length() - 1;
            while (leftP < rightP) {
                if (sb.charAt(leftP) != sb.charAt(rightP)) {
                    return false;
                }
                leftP++;
                rightP--;
            }
            return true;
        }
    }
}
