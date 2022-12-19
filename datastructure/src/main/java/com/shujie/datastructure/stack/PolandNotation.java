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

        //中缀表达式
        String s = "100+((20+3)*4)-5";
        String s2 = "1+((2+3)*4)-5";
        //把中缀表达式转为list
        List<String> expressionList = toInfixExpressionList(s2);
        System.out.println("把中缀表达式转为list = "+expressionList);
        //将中缀表达式的list转为后缀表达式的list
        List<String> suffixExpresionList = parSuffixExpresionList(expressionList);
        System.out.println("将中缀表达式的list转为后缀表达式的list = "  + suffixExpresionList);
        //计算
        String calculate = calculate(suffixExpresionList);
        System.out.println("calculate = " + calculate);
    }

    /**
     * 将中缀表达式的list转为后缀表达式的list
     * example:
     * [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] -> [1,2,3,+,4,*,+,5,-]
     * 思路：将中缀表达式 -> 后缀表达式
     *
     */
    public static List<String> parSuffixExpresionList(List<String> ls) {
        Stack<String> stack = new Stack<>();//存放符号
        List<String> list = new ArrayList<>();//存放计算中间结果
        for (String item :
                ls) {
            if (item.matches("\\d+")){//假如是数字
                list.add(item);
            }else if (item.equals("(")){
                stack.push(item);
            }else if (item.equals(")")){//如果是右括号，则循环弹出符号栈的运算符，并且加入到到list，直到遇到左括号为止，此时将这对括号丢弃。
                while (!stack.peek().equals("(")){
                    list.add(stack.pop());
                }
                stack.pop();//遇到"("，弹出
            }else {//stack栈顶运算符优先级大于等于item，将stack栈顶弹出并加入到list中去。否则将item加入stack
                while (stack.size() > 0 && Operation.getValue(stack.peek()) >= Operation.getValue(item)){
                    list.add(stack.pop());
                }
                stack.push(item);
            }
        }

        while (stack.size() != 0){
            list.add(stack.pop());
        }
        return list;
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
        if (s.equals("")) {
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
                        && (s.charAt(pointer) >= 48 && s.charAt(pointer) <= 57)) {
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

class Operation{
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("not a operation");
                break;
        }
        return result;
    }
}