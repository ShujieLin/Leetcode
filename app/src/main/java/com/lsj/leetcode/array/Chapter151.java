package com.lsj.leetcode.array;

/**
 * @description:
 * @date: 2022/2/8
 * @author: linshujie
 */
public class Chapter151 {
    public static void main(String[] args) {
        String s = "  ni  di ";
        reverseWords(s);
    }

    public static String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        //去掉前空格
//        for (int i = 0; i < s.length(); i++) {
//            if (left > right)
//                break;
//
//            if (s.charAt(i) != ' '){
//                break;
//            }
//            left ++;
//            System.out.println(left);
//        }


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
            if (c != ' '){
                stringBuilder.append(c);
            }else if (stringBuilder.charAt(stringBuilder.length() - 1) != ' '){
                stringBuilder.append(c);
            }
            left ++;
        }
        System.out.println("\"" + stringBuilder.toString() + "\"");

        return "";
    }
}
