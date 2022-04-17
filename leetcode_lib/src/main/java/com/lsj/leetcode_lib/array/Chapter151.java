package com.lsj.leetcode_lib.array;

/**
 * @description:
 * @date: 2022/2/8
 * @author: linshujie
 */
public class Chapter151 {
    public static void main(String[] args) {
        String s = "     ni   linshujie  hao    ";
//        reverseWords(s);
        Solution.reverseWords(s);
    }

    public static String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        //去掉前空格
        while (left <= right && s.charAt(left) == ' '){
            left ++;
            System.out.println(left);
        }

        //去掉后面空格
        while (right >= left && s.charAt(right) == ' '){
            right --;
            System.out.println(right);
        }

        //去掉中间空格
        StringBuilder stringBuilder = new StringBuilder();
        while (left <= right){
            char c = s.charAt(left);
            if (c != ' '){//加非空char
                stringBuilder.append(c);
            }else if (stringBuilder.charAt(stringBuilder.length() - 1) != ' '){//加第一个空格
                stringBuilder.append(c);
            }
            left ++;
        }
        System.out.println("\"" + stringBuilder + "\"");

        reserveAllChar(stringBuilder,0,stringBuilder.length() - 1);

        //逐个单词进行单词内反转
        reserveSingleWord(stringBuilder);
        System.out.println(stringBuilder);
        return "";
    }

    private static void reserveSingleWord(StringBuilder stringBuilder) {
        int start = 0,end = 0;//每个单词的起始和结束
        while (start < stringBuilder.length()){
            //找到每个单词的endIndex
//            while (stringBuilder.charAt(end) != ' ' && end < stringBuilder.length()){
//                end ++;
////                ++end;
//            }

            while (end < stringBuilder.length() && stringBuilder.charAt(end) != ' '){
                end++;
            }

            //反转
            reserveAllChar(stringBuilder,start,end - 1);
            //获取下一个单词的起始和结束
            start = end + 1;
            end = start;
        }
    }

    private static void reserveAllChar(StringBuilder stringBuilder, int left, int right) {
        //反转所有char
        while (left < right){
            //设置一个临时变量,存储反转前的左边值
            char leftTmp = stringBuilder.charAt(left);
            stringBuilder.setCharAt(left ++,stringBuilder.charAt(right));
            stringBuilder.setCharAt(right --,leftTmp);
        }
    }

    static class Solution {
        public static String reverseWords(String s) {
            int leftIndex = 0, rightIndex = s.length() - 1;
            //去除前面空格
            while (leftIndex < s.length() && s.charAt(leftIndex) == ' '){
                leftIndex ++;
                System.out.println(leftIndex);
            }
            //去除后面空格
            while (rightIndex > 0 && s.charAt(rightIndex) == ' '){
                rightIndex --;
                System.out.println(rightIndex);
            }
            //去除中间多余的空格：把字符和中间一个空格逐个添加到stringbuilder中
            StringBuilder sb = new StringBuilder();
            while (leftIndex <= rightIndex){
                if (s.charAt(leftIndex) != ' '){
                    sb.append(s.charAt(leftIndex));
                }else if (sb.charAt(sb.length() - 1) != ' '){
                    sb.append(' ');
                }
                leftIndex ++;
            }
            System.out.println(sb);
            //全部反转
            reverseWords(sb,0,sb.length() - 1);
            System.out.println(sb);
            //逐个单词反转
            reverseEachWords(sb);
            System.out.println(sb);
            return sb.toString();
        }

        private static void reverseEachWords(StringBuilder sb) {
            int length = sb.length();
            //每个单词的起始下标
            int startIndex = 0,endIndex = 0;
            while (startIndex < length && endIndex < length){
                while (endIndex < sb.length() && sb.charAt(endIndex) != ' '){
                    endIndex ++;
                }
                //反转每个单词
                reverseWords(sb,startIndex,endIndex - 1);
                //重置起始结束下标
                startIndex = endIndex + 1;
                endIndex = startIndex;
            }
        }

        private static void reverseWords(StringBuilder sb, int leftIndex, int rightIndex) {
            while (leftIndex < rightIndex){
                char tempChar = sb.charAt(leftIndex);
                sb.setCharAt(leftIndex ++,sb.charAt(rightIndex));
                sb.setCharAt(rightIndex -- ,tempChar);
            }
        }

    }
}


