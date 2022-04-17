package com.lsj.leetcode_lib.array;

/**
 * @Description:
 * @Author: linshujie
 * @Date: 2022/1/27
 */
public class Chapter14 {
    public static String longestCommonPrefix2(String[] strs){
        if (strs.length == 0 || strs == null)
            return "";

        //第一个作为前缀
        String prefix = strs[0];
        //第一个和后面的分别进行对比
        for (int i = 1; i < strs.length; i++) {
            //比较两者，只需要执行最短的字符串。
            int minLength = Math.min(prefix.length(),strs[i].length());

            int index = 0;
            //遍历两个字符串的每个char，假如相等，则进行标记
            for (int j = 0; j < minLength; j++) {
                if (prefix.charAt(j) == strs[i].charAt(j)){
                    index ++;
                }else {//假如有不一样的，退出for循环
                    break;
                }
            }

            //截取相同的前缀
            prefix = prefix.substring(0,index);
        }
        return prefix;
    }


    public static String longestCommonPrefix(String[] strs) {
        //判断空
        if ((strs == null) || (strs.length == 0))
            return "";

        //第一个字符串作为前缀
        String prefix = strs[0];

        //遍历
        for (int i = 1; i < strs.length; i++) {
            //获取两者中长度小的数组
            int minlength = Math.min(prefix.length(),strs[i].length());
            int index = 0;
            while (index < minlength &&
                    prefix.charAt(index) == strs[i].charAt(index)){
                index ++;
            }
            prefix = prefix.substring(0,index);

            if (prefix.length() == 0)
                break;
        }

        return prefix;
    }
}
