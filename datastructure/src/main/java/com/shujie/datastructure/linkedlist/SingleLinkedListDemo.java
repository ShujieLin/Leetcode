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
        /*linkedList.list();
        linkedList.updataNode(new HeroNode(2,"hi","hello"));
        linkedList.list();
        linkedList.delete(heroNode2);
        linkedList.list();*/

        /*int count = SingleLinkedList.getCount(linkedList.head);
        System.out.println("count is " + count);*/

        linkedList.list();

        /*SingleLinkedList.getReverseNode(linkedList.head, 0);
        SingleLinkedList.getReverseNode(linkedList.head, 4);
        SingleLinkedList.getReverseNode(linkedList.head, 3);*/

        SingleLinkedList.reverseLinkedList(linkedList.head);
        System.out.println("反转链表");
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
            } else if (tempNode.next.no == node.no) {
                isNodeExist = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (!isNodeExist) {
            node.next = tempNode.next;
            tempNode.next = node;
        } else {
            System.out.println(node.no + "  has already exist");
        }
    }

    public void updataNode(HeroNode node) {
        if (head.next == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        HeroNode tempNode = head;
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

    public void delete(HeroNode node) {
        if (head.next == null) {
            System.out.println("linkedList is null!");
            return;
        }
        HeroNode tempNode = head;
        boolean isFound = false;
        while (tempNode.next != null) {
            if (tempNode.next.no == node.no) {
                isFound = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (isFound) {
            tempNode.next = tempNode.next.next;
        } else {
            System.out.println("not found!");
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

    /**
     * 获取单链表头结点的个数，假如带头结点，不需要统计头结点
     *
     * @return
     */
    public static int getCount(HeroNode headNode) {
        int count = 0;
        if (headNode.next == null) {
            return count;
        }
        HeroNode tempNode = headNode;

        while (tempNode.next != null) {
            tempNode = tempNode.next;
            count++;
        }
        return count;
    }

    /**
     * 查找倒数第k个结点
     *
     * @param reverseIndex 倒数第几个
     * @return
     */
    public static HeroNode getReverseNode(HeroNode headNode, int reverseIndex) {
        if (headNode.next == null) {
            System.out.println("node is null or wrong reverseIndex");
            return null;
        }
        int lenght = 0;
        HeroNode tempNode = headNode;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            lenght++;
        }
        if (reverseIndex <= 0 || reverseIndex > lenght) {
            System.out.println("reverseIndex is out of bound");
            return null;
        }
        int reultIndex = lenght - reverseIndex;//3 -> index = 1
        HeroNode resultNode = headNode.next;
        for (int i = 0; i < reultIndex; i++) {
            resultNode = resultNode.next;
        }
        System.out.println("resultNode = " + resultNode.no);
        return resultNode;
    }

    /**
     * 腾讯面试题
     * 反转链表
     * 思路：
     * 1.定义一个结点reverseHead = new HeroHode()
     * 2.从头到尾遍历原来的链表，每取出一个节点，就把它放到reverseHead的最前面。
     * 3.最后,head = reverseHead
     *
     * @param head
     * @return
     */
    public static void reverseLinkedList(HeroNode head) {
        if (head.next == null || head.next.next == null) {//说明只有头结点或者只有一个非头结点
            return;
        }

        HeroNode reverseHead = new HeroNode(0, "", "");//新建头结点，用于接收原来链表的结点
        HeroNode curNode = head.next;//当前节点
        HeroNode nextNode;//下一个节点
        while (curNode != null) {
            nextNode = curNode.next;//保存下一个节点
            curNode.next = reverseHead.next;//当前节点
            reverseHead.next = curNode;
            curNode = nextNode;
        }
        head.next = reverseHead.next;
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