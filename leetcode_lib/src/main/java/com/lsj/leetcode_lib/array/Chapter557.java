package com.lsj.leetcode_lib.array;

/**
 * @description:
 * @date: 2022/2/21
 * @author: linshujie
 */
public class Chapter557 {
    public static void main(String[] args) {
        String s = "God Ding";
        Solution.reverseWords(s);
    }

    static class Solution {
        public static String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            int i = 0;//移动指针
            int start = 0;//记录每个单词的起始坐标
            while (i < s.length()){
                start = i;
                //遍历，找到每个单词的结束下标
                while (i < s.length() && s.charAt(i) != ' '){
                    i++;
                }

                //拼接反转的单词
                for (int j = start; j < i; j++) {
//                    sb.append(s.charAt(start + ));
                    //sb的下标中0，1，2，3分别对应反转单词的下标3,2,1,0
                    //sb的下标中3，4，5分别对应反转单词的下标5,4,3
                    //每个指针指向的下标中，sb添加元素的下标+sb需要添加的元素下标的总和相等。
                    // 推导出：sb需要添加的元素下标 = 起始坐标 + 结束坐标 - 指针
                    sb.append(s.charAt(start + (i - 1) - j));
                }

                //拼接空格,空格可能有多个
                while (i < s.length() && s.charAt(i) == ' '){
                    sb.append(' ');
                    i++;
                }
            }

            System.out.println(sb);
            return sb.toString();
        }
    }
}
