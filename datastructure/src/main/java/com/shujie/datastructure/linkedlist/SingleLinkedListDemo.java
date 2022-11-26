package com.shujie.datastructure.linkedlist;


/**
 * @date: 2022/11/25
 * @author: linshujie
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "A", "AA");
        HeroNode heroNode2 = new HeroNode(2, "B", "BB");
        HeroNode heroNode3 = new HeroNode(3, "C", "CC");
        SingleLinkedList linkedList = new SingleLinkedList();
        /*linkedList.add(heroNode1);
        linkedList.add(heroNode2);
        linkedList.add(heroNode3);*/
        linkedList.addByOrder(heroNode2);
        linkedList.addByOrder(heroNode1);
        linkedList.addByOrder(heroNode3);
        linkedList.addByOrder(heroNode2);
        linkedList.addByOrder(heroNode1);
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
     * 按照变化大小添加，从小到大排列
     * 思路：
     * 1.判空
     * 2.查找需要添加的结点
     * 3.把新的结点进行插入
     *
     * @param node
     */
    public void addByOrder(HeroNode node) {
        if (node == null) return;
        HeroNode tempNode = head;
        boolean isNodeExist = false;//假如结点已经存在了，则不需要添加
        while (tempNode.next != null) {
            if (tempNode.next.no > node.no) {
                break;//找到了适合插入的位置
            }else if (tempNode.next.no == node.no){
                isNodeExist = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (!isNodeExist){
            node.next = tempNode.next;
            tempNode.next = node;
        }else {
            System.out.println(node.no + "  has already exist");
        }


    }


    /**
     * 遍历链表
     * 思路：
     * head赋值给临时变量，通过临时变量进行遍历
     */
    public void list() {
        if (head.next == null) {
            System.out.println("linkedlist is null");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null) {
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