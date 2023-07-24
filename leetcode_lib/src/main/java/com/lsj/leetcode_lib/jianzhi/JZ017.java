package com.lsj.leetcode_lib.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linshujie
 */
public class JZ017 {
    public static void main(String[] args) {

    }

    static class Solution {
        /**
         * 定义两个指针 left 和 right，分别表示子字符串的左边界和右边界。
         * 初始化一个 HashMap targetMap，用于统计字符串 t 中每个字符出现的次数。
         * 初始化变量 count，表示当前子字符串中已经包含了 t 中字符的个数。
         * 初始化两个变量 minLeft 和 minLen，分别表示最短子字符串的左边界和长度，初始值为 0 和正无穷大。
         * 移动右指针 right，不断扩大子字符串的范围，直到子字符串包含了所有 t 中的字符。
         * 对于每个遇到的字符 ch，更新 targetMap[ch]，同时比较 targetMap[ch] 与 0，如果大于等于 0，表示该字符在 t 中存在，将 count 自增。
         * 一旦子字符串包含了所有 t 中的字符，开始移动左指针 left 缩小子字符串的范围，寻找最短子字符串。
         * 对于每个移除的字符 ch，更新 targetMap[ch]，同时比较 targetMap[ch] 与 0，如果大于 0，表示该字符是 t 中所需的，将 count 自减。
         * 检查当前子字符串的长度是否小于 minLen，如果是，则更新 minLen 和 minLeft。
         * 重复步骤 5 和步骤 6，直到右指针到达字符串 s 的末尾。
         * 如果 minLen 仍然是正无穷大，表示不存在符合条件的子字符串，返回空字符串 ""，否则返回以 minLeft 为起点，长度为 minLen 的子字符串。
         * @param s
         * @param t
         * @return
         */
        public String minWindow(String s, String t) {
            //定义容器，hashmap，记录每个字符出现的次数
            Map<Character,Integer> window = new HashMap<>();

            //初始化变量，记录目标当前子字符串中已经包含的t中字符的个数
            int left = 0,right = 0,count = 0;

            //右指针不断右移，
            while (right< s.length()){
                char c1 = s.charAt(right);
                window.put(c1, (window.getOrDefault(c1,0)));
                right++;

                //直到字符串包含所有子字符的个数
                //while ()

            }

            return "";

        }
    }
}
