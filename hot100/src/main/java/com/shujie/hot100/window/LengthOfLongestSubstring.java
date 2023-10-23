package com.shujie.hot100.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linshujie
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int lengthOfLongestSubstring = new Solution().lengthOfLongestSubstring(s);
        System.out.println("lengthOfLongestSubstring = " + lengthOfLongestSubstring);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> hashMap = new HashMap<>();

            int left = 0, right = 0, res = 0;
            while (right < s.length()) {
                //扩大窗口
                char cRight = s.charAt(right);
                hashMap.put(cRight, hashMap.getOrDefault(cRight, 0) + 1);//记录c的数量
                right++;

                System.out.println("left = " + left + " right = " + right);

                //缩小窗口
                while (/*满足条件*/hashMap.get(cRight) > 1) {
                    char cLeft = s.charAt(left);
                    hashMap.put(cLeft,hashMap.get(cLeft) - 1);
                    left++;
                }

                res = Math.max(res, right - left);
            }
            return res;
        }
    }
}
