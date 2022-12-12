package com.shujie.datastructure.stack;

/**
 * @Date: 2022/12/10
 * @Author: linshujie
 */
public class Calculator {


    public static void main(String[] args) {
        String expre = "30+2*2-1";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operationStack = new ArrayStack2(10);

        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int operation = 0;//operation
        int result = 0;
        char ch = ' ';//每次扫描得到的char保存到ch
        String keepNum = "";

        while (true) {
            ch = expre.substring(index, index + 1).charAt(0);
            //判断ch是符号还是数字
            if (operationStack.isOperation(ch)) {
                //当前符号栈是否为空
                if (!operationStack.isEmpty()) {
                    //如果符号栈有操作符就进行比较，如果当前操作符优先级小于或等于栈的操作符，就在数栈pop出两个数,在符号栈pop出一个符号进行运算
                    if (operationStack.priority(ch) <= operationStack.priority(operationStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operation = operationStack.pop();
                        result = numStack.cal(num1, num2, operation);
                        //将得到结果入数栈，
                        numStack.push(result);
                        //然后将当前操作符入符号栈
                        operationStack.push(ch);
                    } else {
                        operationStack.push(ch);
                    }
                } else {
                    operationStack.push(ch);
                }
            } else {//如果是数字，直接入数栈
                /*numStack.push(ch - 48);//ASCII码中符号对应的数字*/
                //往后面一位char检查
                if (!operationStack.isOperation(expre.substring(index+1,index+2).charAt(0))){
                    keepNum += ch;
                }else {
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
            }
            index++;
            if (index >= expre.length()) break;
        }

        while (true) {
            if (operationStack.isEmpty()) break;
            num1 = numStack.pop();
            num2 = numStack.pop();
            operation = operationStack.pop();
            result = numStack.cal(num1, num2, operation);
            numStack.push(result);
        }

        System.out.printf("expression %s = %d", expre, numStack.pop());
    }
}


class ArrayStack2 {
    private int[] stack;
    private int maxSize = -1;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int peek() {
        return stack[top];
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 显示栈的数值，需要从栈顶开始向栈底遍历
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        //需要从栈底开始
        /*for (int i = 0; i < top; i++) {
            System.out.println(stack[i]);
        }*/
        System.out.println("the stack is:");
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d ", i, stack[i]);
            System.out.println();
        }
    }

    /**
     * 返回操作符的优先级
     *
     * @param operation
     * @return
     */
    public int priority(int operation) {
        if (operation == '*' || operation == '/') {
            return 1;
        } else if (operation == '+' || operation == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOperation(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算
     *
     * @param num1
     * @param num2
     * @param operation
     * @return
     */
    public int cal(int num1, int num2, int operation) {
        if (operation == '+') {
            return num2 + num1;
        } else if (operation == '-') {
            return num2 - num1;
        } else if (operation == '*') {
            return num2 * num1;
        } else if (operation == '/') {
            return num2 / num1;
        } else {
            throw new IllegalArgumentException("error operation");
        }
    }
}