package com.lsj.leetcode.array;

/**
 * @Description:
 * @Author: linshujie
 * @Date: 2022/1/28
 */
public class Chapter5 {
    public String longestPalindroe(String s){
        if (s == null || s.length() < 1)
            return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //获取最长扩展长度，一共有两种情况，需要分两种情况遍历。
            //1.把一个字符作为中心的情况
            int len1 = expandAroundCenter(s,i,i);
            //2.把两个字符作为中心的情况
            int len2 = expandAroundCenter(s,i,i+1);
            //获取两种情况中较大的那个的长度。
            int len = Math.max(len1,len2);

            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end + 1);
    }

    /**
     * 往左右两边进行扩散，分为两种，一种情况中心是一个，另一种情况中心是两个
     * @param s
     * @param left
     * @param right
     * @return 回文子串的长度，即两端的中间一共有多少个字符
     */
    private int expandAroundCenter(String s, int left, int right) {
        while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        return right - left - 1;
    }
}