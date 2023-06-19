package com.lsj.leetcode_lib.DP;

/**
 * @author: linshujie
 */
public class C115 {
    public static void main(String[] args) {
        new Solution1().numDistinct("rabbbit","rabbit");

    }

    static class Solution {


        public int numDistinct(String s, String t) {
            return  dp(s,0,t,0);
        }

        private int dp(String s, int sIndex, String t, int tIndex) {

            if (tIndex == t.length()) return 1;
            if (sIndex == s.length()) return 0;


            int res = 0;
            for (int i = sIndex; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(i)){
                    res += dp(s,sIndex + 1, t, tIndex + 1);
                }
            }
            return res;
        }
    }

    // 站在 t 视角的暴力解，超时，就算加备忘录效率也比较低
    static class Solution1 {
        public int numDistinct(String s, String t) {
            return dp(s, 0, t, 0);
        }

        // 定义：返回 s[i..] 中包含子序列 t[j..] 的数量
        int dp(String s, int i, String t, int j) {
            if (j == t.length()) {
                // 子序列全部匹配完成
                return 1;
            }
            if (i == s.length()) {
                return 0;
            }

            int res = 0;
            // 在 s[i..] 中寻找匹配 t[j] 的那个索引 k
            for (int k = i; k < s.length(); k++) {
                if (s.charAt(k) == t.charAt(j)) {
                    // 然后去 s[k+1..] 中寻找子序列 t[j+1..]
                    res += dp(s, k + 1, t, j + 1);
                }
            }
            return res;
        }
    }
// 详细解析参见：
// https://labuladong.github.io/article/?qno=115

}
