package com.shujie.datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式实现计算器功能
 *
 * @author linshujie
 */
public class PolandNotation {
    public static void main(String[] args) {
/*

//        String suffixExpression = "3 4 + 5 * 6 -";
        String suffixExpression = "30 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        System.out.println(Arrays.toString(list.toArray()));
        String result = calculate(list);
        System.out.println("result = " + result);
*/


        String s = "100+((20+3)*4)-5";
        List<String> expressionList = toInfixExpressionList(s);
        System.out.println(expressionList);
    }

    /**
     * 将中缀表达式转换为对应的list
     * example：s = "100+((20+3)*4)-5"
     * 思路：
     * 遍历s，每次遍历一个char
     * 遇到数字开启循环进行拼接numStr，直到遇到符号
     * 遇到符号，直接假如list
     *
     * @param s
     * @return
     */
    public static List<String> toInfixExpressionList(String s) {
        if (s.equals("")){
            throw new IllegalArgumentException();
        }
        List<String> list = new ArrayList<>();
        int pointer = 0;
        int lenght = s.length();
        String numStr = "";
        while (pointer < lenght) {
            if (s.charAt(pointer) < 48 || s.charAt(pointer) > 57) {//ASCII
                list.add(String.valueOf(s.charAt(pointer)));
                pointer++;
            } else {
                while (pointer < lenght
                        && (s.charAt(pointer) >=48  && s.charAt(pointer) <= 57)) {
                    numStr += s.charAt(pointer);
                    pointer++;
                }
                list.add(numStr);
                numStr = "";
            }
        }
        return list;
    }

    /**
     * String suffixExpression = "3 4 + 5 * 6 -";(30+4)*5-6
     * 从左到右扫描，将栈顶和次栈顶入栈，即3和4入栈，遇到运算符，弹出栈3和4，计算3 + 4的值7，入栈
     * 将5入栈，遇到 * ，计算7*5 ，值为35，入栈，遇到 - ，35 - 6 ，得出结果29
     *
     * @param list
     * @return
     */
    private static String calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item :
                list) {
            if (item.matches("\\d+")) {//匹配到多位数
                stack.push(item);
            } else {
                //这里是栈底与栈顶进行运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if (item.equals("+")) {
                    result = num1 + num2;
                } else if (item.equals("-")) {
                    result = num1 - num2;
                } else if (item.equals("*")) {
                    result = num1 * num2;
                } else if (item.equals("/")) {
                    result = num1 / num2;
                }
                stack.push(String.valueOf(result));
            }
        }
        return stack.peek();
    }

    private static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        return new ArrayList<>(Arrays.asList(split));
    }
}