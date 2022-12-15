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

//        String suffixExpression = "3 4 + 5 * 6 -";
        String suffixExpression = "30 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        System.out.println(Arrays.toString(list.toArray()));
        String result = calculate(list);
        System.out.println("result = " + result);
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
                if (item.equals("+")){
                   result = num1 + num2;
                }else if (item.equals("-")){
                    result = num1 - num2;
                }else if (item.equals("*")){
                    result = num1 * num2;
                }else if (item.equals("/")){
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