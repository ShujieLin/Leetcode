package com.lsj.leetcode_lib.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈:从栈底到栈顶对应的温度递减
 * 步骤：
 * 1.正向遍历温度列表temperatures[i]，如果栈为空，将i入栈
 * 2.如果栈不为空，比较栈顶元素preIndex对应的温度temperates[preIndex]和temperatures[i]的大小，如果temperatures[i]更大，让栈顶出栈，
 * 同时把等待天数赋值为i - preIndex.
 * 3.循环直至栈为空或者栈顶对应的温度小于等于当前温度，然后将i进栈。
 *
 *
 * @date: 2022/6/21
 * @author: linshujie
 */
public class Chapter739 {

    class Solution {
        /**
         * 错误答案
         * @param temperatures
         * @return
         */
        public int[] dailyTemperatures(int[] temperatures) {
            //
            Deque<Integer> stack = new LinkedList<>();
            int[] ans = new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {
                int preTemperature = temperatures[i];
                while (stack != null && temperatures[i + 1] > preTemperature){

                    ans[i] = i - stack.peek();
                }
                stack.push(temperatures[i]);
            }

            return ans;
        }

        public int[] dailyTemperatures2(int[] temperatures) {
            int length = temperatures.length;
            int[] ans = new int[length];
            Deque<Integer> stack = new LinkedList<>();

            for (int i = 0; i < length; i++) {
                int temperature = temperatures[i];
                //大于上一个栈顶
                while (!stack.isEmpty() && (temperature > temperatures[stack.peek()])){
                    //出栈的index即为上一个最大的
                    int preIndex = stack.pop();
                    ans[preIndex] = i - preIndex;
                }
                stack.push(i);
            }

            return ans;
        }
    }
}
