package com.lsj.leetcode_lib.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linshujie
 */
public class JZ014 {
    public static void main(String[] args) {

        String s1 = "ab", s2 = "eidbaooo";
        boolean b = new Solution().checkInclusion(s1, s2);
        System.out.println("b = " + b);
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int left = 0, right = 0;

            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();
            for (char c :
                    s1.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0));
            }
            boolean res = false;
            int valid = 0;
            while (right < s2.length()) {
                char c1 = s2.charAt(right);
                right++;
                if (need.containsKey(c1)) {
                    window.put(c1, window.getOrDefault(c1, 0) + 1);
                    if (need.get(c1).equals(window.get(c1))) valid++;
                }

                while (right - left > s1.length()) {
                    System.out.println("valid = " + valid);
                    char c2 = s2.charAt(left);
                    left++;
                    if (need.containsKey(c2)) {
                        window.put(c2, window.getOrDefault(c2, 0) - 1);
                        if (need.get(c2).equals(window.get(c2))) valid--;
                    }
                }


                System.out.println("s2 = " + s2.substring(left,right));


            }

            return res;
        }
    }
}