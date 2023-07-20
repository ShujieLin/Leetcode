package com.lsj.leetcode_lib.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linshujie
 */
public class JZ015 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> anagrams = new Solution().findAnagrams(s, p);
        System.out.println("anagrams = " + anagrams);
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int left = 0,right = 0;
            int[] count1 = new int[26];
            int[] count2 = new int[26];
            for (int i = 0; i < p.length(); i++) {
                count1[p.charAt(i) - 'a'] ++;
            }

            List<Integer> res = new ArrayList<>();
            System.out.println("count1 = " + Arrays.toString(count1));
            while (right < s.length()){
                count2[s.charAt(right) - 'a']++;

                while (right - left + 1 == p.length()){
                    System.out.println("left = " + left + " right = " + right + " window = " + Arrays.toString(count2));
                    if (Arrays.equals(count1,count2)){
                        res.add(left);
                    }
                    count2[s.charAt(left) - 'a']--;
                    left ++;
                }
                right ++;
            }
            return res;
        }
    }
}
