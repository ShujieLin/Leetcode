package com.lsj.leetcode_lib.dp;

import java.util.Arrays;

/**
 * @author: linshujie
 */
public class C115 {
    public static void main(String[] args) {
        new Solution1().numDistinct("rabbbit", "rabbit");
    }

    static class Solution {

        public int numDistinct(String s, String t) {
            return dp(s, 0, t, 0);
        }

        private int dp(String s, int sIndex, String t, int tIndex) {

            if (tIndex == t.length()) return 1;
            if (sIndex == s.length()) return 0;

            int res = 0;
            for (int i = sIndex; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(i)) {
                    res += dp(s, sIndex + 1, t, tIndex + 1);
                }
            }
            return res;
        }
    }

    static class Solution2 {
        public int numDistinct(String s, String t) {
            memo = new int[s.length()][t.length()];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dp(s, 0, t, 0);
        }

        int[][] memo;

        // 定义：该函数返回 s[i..] 中的子序列 t[j..] 的数量
        int dp(String s, int i, String t, int j) {
            int m = s.length(), n = t.length();
            if (j == n) {
                // 子序列全部匹配完成
                return 1;
            }
            if (n - j > m - i) {
                // 待匹配子序列的长度不应该比字符串的长度还要短
                return 0;
            }
            if (memo[i][j] != -1) {
                // 已经计算过对应状态
                return memo[i][j];
            }
            int res = 0;

            //s[i] 能匹配上 t[i]，例如 s = aab  t = ab    -> aab 1：a_b 匹配 ab  2：_ab 匹配 ab
            // 状态转移方程
            if (s.charAt(i) == t.charAt(j)) {
                res += dp(s, i + 1, t, j + 1) + dp(s, i + 1, t, j);
            } else {//s[i] 匹配不上 t[i]，例如：s = abc  t = d
                res += dp(s, i + 1, t, j);
            }
            memo[i][j] = res;
            return res;
        }
    }
    // 详细解析参见：
    // https://labuladong.github.io/article/?qno=115


    // 站在 t 视角的暴力解，超时，就算加备忘录效率也比较低
    static class Solution1 {
        public int numDistinct(String s, String t) {
            return dp(s, 0, t, 0);
        }

        // 定义：返回 s[i..] 中包含子序列 t[j..] 的数量
        int dp(String s, int i, String t, int j) {
            if (j == t.length()) {
                System.out.println(" <- 1" );
                // 子序列全部匹配完成
                return 1;
            }
            if (i == s.length()) {
                System.out.println(" <- 0" );
                return 0;
            }
            System.out.println("-> i = " + i + " j = " + j);

            int res = 0;
            // 在 s[i..] 中寻找匹配 t[j] 的那个索引 k
            for (int k = i; k < s.length(); k++) {
                if (s.charAt(k) == t.charAt(j)) {
                    // 然后去 s[k+1..] 中寻找子序列 t[j+1..]

                    //System.out.println("s = " + s + " " + (k + 1) + " t = " + t + " " + (t + 1));
                    res += dp(s, k + 1, t, j + 1);
                    //System.out.println("res = " + res);
                }
            }
            System.out.println(" <- res = " + res);
            return res;
        }
    }
    // 详细解析参见：
    // https://labuladong.github.io/article/?qno=115
}