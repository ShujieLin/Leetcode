package com.lsj.leetcode_lib.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @date: 2022/2/18
 * @author: linshujie
 */
public class Chapter118 {
    public static void main(String[] args) {
        Solution.generate(5);
    }

    static class Solution {
        public static List<List<Integer>> generate(int numRows) {
            if (numRows == 0)
                return null;

            List<List<Integer>> list = new ArrayList();//存放所有行的数据
            for (int j = 0; j < numRows; j++) {
                List rowList = new ArrayList<>();//杨辉三角每行的数据。
                for (int k = 0; k <= j; k++) {
                    if (k == 0){//每行第一个元素
                        rowList.add(1);
                    }else if (k == j){//每行最后一个元素
                        rowList.add(1);
                    }else {
                        rowList.add(list.get(j - 1).get(k) + list.get(j - 1).get(k - 1));
                    }
                }
                list.add(rowList);
            }
            return list;
        }
    }
}
