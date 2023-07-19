package com.lsj.leetcode_lib.jianzhi;

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

            String sub ;
            boolean res = false;
            while (right < s2.length()) {
                right ++;
                sub = s2.substring(left, right);
                System.out.println("sub = " + sub);

                while (!sub.contains(s1) && left < right){
                    left ++;
                    sub = s2.substring(left,right);
                }

                if (sub.equals(s1)) res = true;
            }
            return res;
        }
    }
}
