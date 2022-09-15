package com.lsj.leetcode_lib.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @date: 2022/6/17
 * @author: linshujie
 */
public class Chapter155 {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.peek(),val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            if (stack.isEmpty()) return 0;
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
