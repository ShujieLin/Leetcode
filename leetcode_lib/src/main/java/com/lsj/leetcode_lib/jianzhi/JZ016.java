package com.lsj.leetcode_lib.jianzhi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author linshujie
 */
public class JZ016 {
    public static void main(String[] args) {

        String s = "";
        int length = new Solution().lengthOfLongestSubstring(s);
        System.out.println("length = " + length);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> window = new HashSet<>();
            int left = 0, right = 0;
            int res = Integer.MIN_VALUE;
            while (right < s.length()) {
                char c1 = s.charAt(right);
                //假如s[right]存在重复字符
                if (window.contains(c1)) {
                    //移动左边指针，直到移除重复字符
                    while (left < s.length() && left < right) {
                        char c2 = s.charAt(left);
                        window.remove(c2);
                        left++;
                        if (c2 == c1) break;
                    }
                }
                window.add(c1);
                right++;
                //否则，更新最大长度
                res = Math.max(res, right - left);
                System.out.println("window = " + window + " left =" + left + " right = " + right);
            }
            return res == Integer.MIN_VALUE ? 0 : res;
        }
    }
}