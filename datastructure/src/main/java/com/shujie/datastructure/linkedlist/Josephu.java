package com.shujie.datastructure.linkedlist;

/**
 * 约瑟夫问题
 *
 * @date: 2022/12/1
 * @author: linshujie
 */
public class Josephu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.list();

        circleSingleLinkedList.countBoy(1,2,5);
    }


}

/**
 * 环形单向链表
 */
class CircleSingleLinkedList {
    //第一个结点
    private Boy first;

    /**
     * 添加男孩
     *
     * @param nums
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("不存在结点数量小于1的环形");
            return;
        }

        Boy curBoy = null;//辅助节点
        for (int i = 0; i < nums; i++) {
            Boy boy = new Boy(i + 1);
            //新建第一个结点的时候比较特殊，因为它会自己指向自己
            if (i == 0) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历男孩
     */
    public void list() {
        if (first == null) {
            System.out.println("circle linked list is null");
            return;
        }
        Boy curBoy = first;//辅助节点

        while (true) {
            System.out.println(curBoy.getNo());
            if (curBoy.getNext() != first) {
                curBoy = curBoy.getNext();
            } else if (curBoy.getNext() == first) {
                break;
            }

        }
    }


    /**
     * 问题：在坐了一圈的小孩里面循环数数，每次数到的小孩进行出圈，直到圈里面只剩下一个小孩
     *
     * 根据用户输入，计算小孩出圈顺序
     *
     * @param startNum 从第几个小孩开始数数
     * @param countNum 数几下
     * @param nums     最初有多少小孩在圈里面
     */
    public void countBoy(int startNum, int countNum, int nums) {
        if (first == null || startNum > nums || startNum < 0 || nums < 0){
            System.out.println("error argument!");
            return;
        }

        //1.创建辅助指针，执行环形链表的最后节点
        Boy helper = first;
        while (true){
            if (helper.getNext() != first){
                helper = helper.getNext();
            }else {
                break;
            }
        }

        //2.小孩报数的前，helper和first同时移动startNum - 1次
        for (int i = 0; i < startNum - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //3.小孩报数的时候，helper和first同时移动countNum次，出圈，直到圈中只有一个节点
        while (first.getNext() != first){
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //将first指向的小孩出圈
            System.out.println("out boy " + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy getNext() {
        return next;
    }

    public int getNo() {
        return no;
    }
}