package com.shujie.datastructure.queue;

/**
 * @date: 2022/11/20
 * @author: linshujie
 */
public class ArrayQueueDemo {


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
