package com.lsj.leetcode_lib.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linshujie
 */
public class JZ48 {
    public static void main(String[] args) {
        String s = new String("bacabcbda");
        int i = new Solution3().lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }

    static class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            int left = 0,right = 0;
            int res= 0;
            Map<Character,Integer> window = new HashMap<>();
            while (right < s.length()){
                char c = s.charAt(right);
                window.put(c,window.getOrDefault(c,0) + 1);
                right ++;
                System.out.println(" " + s.substring(left,right));
                while (window.get(c) > 1){//有重复的数据
                    char d = s.charAt(left);
                    window.put(d,window.get(d)- 1);
                    left ++;
                    System.out.println(" " + s.substring(left,right));
                }
                res = Math.max(res,right - left);
            }
            return res;
        }
    }

    static class Solution2 {
        public int lengthOfLongestSubstring(String s) {

            Map<Character, Integer> window = new HashMap<>();

            int res = 0;
            int left = 0, right = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                window.put(c, window.getOrDefault(c, 0) + 1);
                right++;

                System.out.println("right = " + right + " " + s.substring(left, right));
                //左边开始滑动
                while (window.get(c) > 1) {//假如有重复的元素
                    char d = s.charAt(left);
                    window.put(d, window.getOrDefault(d, 0) - 1);
                    left++;
                    System.out.println("left = " + left + " " + s.substring(left, right));
                }
                res = Math.max(res, right - left);
                System.out.println("update res = " + res);
            }

            return res;
        }
    }

    // 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();

            int left = 0, right = 0;
            int res = 0; // 记录结果
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据的一系列更新
                window.put(c, window.getOrDefault(c, 0) + 1);

                System.out.println("right = " + right + " " + s.substring(left, right));
                // 判断左侧窗口是否要收缩
                while (window.get(c) > 1) {
                    char d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    window.put(d, window.get(d) - 1);
                    System.out.println("left = " + left + " " + s.substring(left, right));
                }
                // 在这里更新答案
                res = Math.max(res, right - left);
                System.out.println(" update res = " + res);
            }
            return res;
        }
    }
// 详细解析参见：
// https://labuladong.github.io/article/?qno=剑指 Offer 48

}
