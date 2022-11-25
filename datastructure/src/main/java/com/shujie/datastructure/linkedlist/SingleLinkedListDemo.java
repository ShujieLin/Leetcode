package com.shujie.datastructure.linkedlist;

/**
 * @date: 2022/11/25
 * @author: linshujie
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"A","AA");
        HeroNode heroNode2 = new HeroNode(2,"B","BB");
        HeroNode heroNode3 = new HeroNode(3,"C","CC");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(heroNode1);
        linkedList.add(heroNode2);
        linkedList.add(heroNode3);
        linkedList.list();
    }
}

class SingleLinkedList {
    //头结点不存放数据，用于识别该链表
    HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点思路：
     * 1.遍历，找到链表的最后节点
     * 2.将链表最后节点指向加入的结点
     */
    public void add(HeroNode heroNode) {
        if (heroNode == null) return;
        //赋值给临时变量
        HeroNode tempNode = head;
        //查找最后一个
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        //这时候，tempNode指向了最后一个节点
//        heroNode.next = tempNode;
        tempNode.next = heroNode;
    }

    /**
     * 遍历链表
     * 思路：
     * head赋值给临时变量，通过临时变量进行遍历
     */
    public void list(){
        if (head.next == null) {
            System.out.println("linkedlist is null");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            System.out.println(temp.no + " " + temp.name + " " + temp.nickName);
        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
}