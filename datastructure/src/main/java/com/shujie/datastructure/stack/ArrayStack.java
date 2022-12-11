package com.shujie.datastructure.stack;

//import java.util.Scanner;

import java.util.Scanner;

/**
 * @Date 2022/12/9
 * @Author linshujie
 */
class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show");
            System.out.println("exit");
            System.out.println("push");
            System.out.println("pop");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("pls input a number");
                    stack.push(scanner.nextInt());
                    break;
                case "pop":
                    try {
                        int result = stack.pop();
                        System.out.println("the result be poped is :" + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
    }
}

class ArrayStack {
    private int[] stack;
    private int maxSize = -1;
    private int top = -1;

    public ArrayStack(int maxSize) {
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
}
