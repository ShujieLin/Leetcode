package com.lsj.leetcode_lib.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @date: 2022/6/14
 * @author: linshujie
 */
public class Chapter20 {

    public static void main(String[] args) {
        new Solution().isValid(")(");

//        System.out.println(2 / 2 + "");
//        System.out.println((2 / 1) + "");
    }

    static class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 != 0){
                return false;
            }

            Map<Character,Character> characterMap = new HashMap<>();
            characterMap.put('[',']');
            characterMap.put('(',')');
            characterMap.put('{','}');
            //判断
            Deque<Character> stack = new LinkedList();
            for (int i = 0; i < s.length(); i++) {
                //通过哈希表的key判断是否是连续左括号
                if (characterMap.containsKey(s.charAt(i))){
                    stack.push(s.charAt(i));
                }else {
                    if (stack.isEmpty() ||
                            !characterMap.get(stack.peek()).equals(s.charAt(i))) return false;
                    stack.pop();
                }
            }

            return stack.isEmpty();
        }
    }
}
