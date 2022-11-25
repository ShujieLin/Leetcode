package com.shujie.datastructure.queue;

/**
 * @date: 2022/11/22
 * @author: linshujie
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {

    }

    class CircleArray {
        private int maxSize;//数组的最大容量
        private int front;//执行列队的第一个元素
        private int rear;//指向队列最后一个元素的最后一个位置，空出一个作为约定空间
        private int[] arr;

        public CircleArray(int maxSize) {
            this.maxSize = maxSize;
            this.arr = new int[maxSize];
        }

        public boolean isFull() {
            return (rear + 1) % maxSize == front;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int n) {
            if (isFull()) {
                System.out.println("queue is full!");
                return;
            }
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }

        /**
         * 取出一个数据
         *
         * @return
         */
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("queue is null!");
            }
            //1.把数据存放到临时变量 2.front后移 3.返回临时变量
            int temp = arr[front];
            front = (front + 1) % maxSize;
            return temp;
        }


        /**
         * 返回第一个数据
         *
         * @return
         */
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("queue is null!");
            }
            return arr[front];
        }

        public void show() {
            if (isEmpty()) {
                System.out.println("queue is null!");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d", i % maxSize, arr[i % maxSize]);
            }
        }

        public int size() {
            return (rear + maxSize - front) % maxSize;
        }


    }
}
