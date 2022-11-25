package com.shujie.datastructure.queue;

import java.util.Scanner;

/**
 * @date: 2022/11/20
 * @author: linshujie
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("p(pop):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.show();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.add(value);
                    break;
                case 'p':
                    int res = arrayQueue.pop();
                    System.out.printf("取出的队列头数据是%d\n",res);
                    break;
                case 'h':
                    int res2 = arrayQueue.peek();
                    System.out.printf("队列头的数据是%d\n",res2);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;
            }
        }
        System.out.println("exit");
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("queue is full!");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("queue is null!");
        }
        front++;
        return arr[front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("queue is null!");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d", i, arr[i]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is null!");
        }
        return arr[front + 1];
    }

}
