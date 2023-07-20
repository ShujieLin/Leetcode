package com.lsj.leetcode_lib.jianzhi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linshujie
 */
public class JZ014 {
    public static void main(String[] args) {
        /*String s1 = "cb", s2 = "eidbaooo";*/
        String s1 = "ob", s2 = "eidboaoo";
        boolean b = new Solution().checkInclusion(s1, s2);
        System.out.println("b = " + b);
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int left = 0, right = 0;
            //初始化count1
            int[] count1 = new int[26];
            int[] count2 = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                count1[s1.charAt(i) - 'a']++;
            }
            System.out.println("count1 = " + Arrays.toString(count1));

            while (right < s2.length()) {
                count2[s2.charAt(right) - 'a']++;

                while (right - left + 1 == s1.length()) {
                    System.out.println(
                            "left = " + left + " right = " + right + " window = " + s2.substring(
                                    left, right) + " count2 = " + Arrays.toString(count2));

                    //关键：当窗口长度等于目标长度的时候进行判断
                    //假如符合得到结果，假如不符合，窗口left后移一位，接着right后移一位，继续判断
                    //直到终止
                    if (Arrays.equals(count1, count2)) {
                        return true;
                    }
                    count2[s2.charAt(left) - 'a']--;
                    left++;
                }

                right++;
            }
            System.out.println("count2 = " + Arrays.toString(count2));
            return false;
        }
    }
}