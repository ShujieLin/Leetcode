package com.shujie.datastructure.tree;

/**
 * @author: linshujie
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "A");
        HeroNode node2 = new HeroNode(2, "B");
        HeroNode node3 = new HeroNode(3, "C");
        HeroNode node4 = new HeroNode(4, "D");
        HeroNode node5 = new HeroNode(5, "E");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();

        //前序遍历
        System.out.println("前序遍历");
        int searchNo = 15;
        HeroNode resNode = binaryTree.preOrderSearch(searchNo);
        if (resNode != null)
            System.out.printf("no = %d,name = %s", resNode.getNo(), resNode.getName());
        else System.out.printf("没有找到no = %d的节点", searchNo);
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("null");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("null");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("null");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null)
            return root.preOrderSearche(no);
        else
            return null;
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null)
            return root.infixOderSearch(no);
        else
            return null;
    }

    public HeroNode postOderSearch(int no) {
        if (root != null)
            return root.postOderSearch(no);
        else
            return null;
    }
}

/**
 * 节点
 */
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void preOrder() {
        System.out.println(this);//输出父结点
        if (this.left != null) {//递归遍历左子树
            this.left.preOrder();
        }
        if (this.right != null) {//递归遍历右子树
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


    public HeroNode preOrderSearche(int no) {
        //比较当前节点
        if (this.no == no) return this;

        //判断当前节点的左节点是否为null，如果不为空，递归前序查找
        //如果找到则返回
        HeroNode resultNode = null;
        if (this.left != null) {
            resultNode = this.left.preOrderSearche(no);
        }
        if (resultNode != null) return resultNode;

        if (this.right != null) {
            resultNode = this.right.preOrderSearche(no);
        }
        return resultNode;
    }

    public HeroNode infixOderSearch(int no) {
        HeroNode resNode = null;
        //递归查找左字树
        if (this.left != null) {
            resNode = this.left.infixOderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //如果找到，就返回当前节点
        if (this.no == no) return this;

        if (this.right != null)
            resNode = this.right.infixOderSearch(no);

        return resNode;
    }

    public HeroNode postOderSearch(int no) {
        HeroNode resultNode = null;
        if (this.left != null)
            resultNode = this.left.postOderSearch(no);
        if (resultNode != null)
            return resultNode;//说明在左子树

        if (this.right != null)
            resultNode = this.right.postOderSearch(no);
        if (resultNode != null)
            return resultNode;

        if (this.no == no) return this;
        return resultNode;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}

