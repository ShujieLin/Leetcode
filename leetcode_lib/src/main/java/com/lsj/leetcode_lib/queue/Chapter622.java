package com.lsj.leetcode_lib.queue;

import java.util.Arrays;

/**
 * @description:
 * 方法一:使用循环数组实现
 * tailindex = （headindex + count - 1）% capacity
 * @date: 2022/2/28
 * @author: linshujie
 */
public class Chapter622 {
    public static void main(String[] args) {
        Chapter622 chapter622 = new Chapter622(3);
        chapter622.enQueue(1);
        chapter622.enQueue(2);
        chapter622.enQueue(3);
        chapter622.enQueue(4);
        chapter622.Rear();
        chapter622.isFull();
        chapter622.deQueue();
        chapter622.enQueue(4);
        chapter622.Rear();
//        chapter.enQueue(6);
//        chapter.deQueue();
//        chapter.deQueue();
        System.out.println(chapter622);
    }



    //循环队列
    private int[] queue;
    private int capacity;
    //队列元素数量
    private int count = 0;
    private int headIndex = 0;

    public Chapter622(int k) {
        capacity = k;
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        //假如满了
        if (count == capacity)
            return false;
        //假如没满，则入队
        //在当前队列尾部的下一个插入新元素。
        queue[((headIndex + count - 1)  + 1 ) % capacity] = value;
        count ++;
        return true;
    }

    public boolean deQueue() {
        if (count == 0)
            return false;

//        queue[(headIndex + count - 1) % capacity] = 0;
        headIndex = (headIndex + 1) % capacity;
        count --;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return queue[headIndex];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return queue[(headIndex + count - 1) % capacity];

    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "queue=" + Arrays.toString(queue) +
                ", capacity=" + capacity +
                ", count=" + count +
                ", headIndex=" + headIndex +
                '}';
    }
}
