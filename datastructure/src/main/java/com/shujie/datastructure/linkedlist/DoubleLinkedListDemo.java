package com.shujie.datastructure.linkedlist;

/**
 * @date: 2022/11/30
 * @author: linshujie
 */
public class DoubleLinkedListDemo {


}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
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
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.no + " " + temp.name + " " + temp.nickName);
        }
    }

    /**
     * 添加节点思路：
     * 1.遍历，找到链表的最后节点
     * 2.将链表最后节点指向加入的结点
     */
    public void add(HeroNode2 heroNode) {
        if (heroNode == null) return;
        //赋值给临时变量
        HeroNode2 tempNode = head;
        //查找最后一个
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        //这时候，tempNode指向了最后一个节点
        tempNode.next = heroNode;
        heroNode.pre = tempNode;
    }

    public void updataNode(HeroNode2 node) {
        if (head.next == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        HeroNode2 tempNode = head;
        boolean isFound = false;
        while (tempNode.next != null) {
            if (tempNode.no == node.no) {
                isFound = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (isFound) {
            tempNode.name = node.name;
            tempNode.nickName = node.nickName;
        } else {
            System.out.println("not found!");
        }

    }

    /**
     * 不需要找到需要删除节点的前一个节点
     *
     * @param node
     */
    public void delete(HeroNode2 node) {
        if (head.next == null) {
            System.out.println("linkedList is null!");
            return;
        }
        HeroNode2 tempNode = head.next;//找到需要删除的结点
        boolean isFound = false;
        while (tempNode != null) {
            if (tempNode.no == node.no) {
                isFound = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (isFound) {
            tempNode.pre.next = tempNode.next;
            if (tempNode.next != null) {
                tempNode.next.pre = tempNode.pre;
            }
        } else {
            System.out.println("not found!");
        }
    }


}


class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}