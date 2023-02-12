package com.shujie.datastructure.tree.treaded;

/**
 * @author: linshujie
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "a");
        HeroNode node2 = new HeroNode(3, "b");
        HeroNode node3 = new HeroNode(6, "c");
        HeroNode node4 = new HeroNode(8, "d");
        HeroNode node6 = new HeroNode(10, "f");
        HeroNode node7 = new HeroNode(14, "g");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node6);
        node3.setLeft(node7);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);
        binaryTree.threadedNodes();

        //测试10结点
        System.out.println("10节点的前驱结点 = " + node6.getLeft() + " 后继结点 = " + node6.getRight());
    }
}

class BinaryTree {
    private HeroNode root;
    private HeroNode pre;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    /**
     * 中序线索化
     *
     * @param node
     */
    public void threadedNodes(HeroNode node) {
        if (node == null) return;

        //1.先线索后左子树
        threadedNodes(node.getLeft());
        //2.线索后当前结点
        //处理当前结点的前驱结点
        if (node.getLeft() == null) {
            node.setLeft(pre);//让当前节点的左指针指向前驱结点。
            node.setLeftType(1);//当前结点的左指针类型为指向前驱结点。
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            pre.setRightType(1);
        }

        //每处理完一次节点，让当前节点成为下一个节点的前驱结点
        pre = node;

        //3.线索化后子树
        threadedNodes(node.getRight());
    }

    public void deleteNode(int no) {
        if (root != null) {
            if (root.getNo() == no) root = null;
            else root.deleteNode(no);
        } else {
            System.out.println("tree is null");
        }
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

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //0表示指向左子树，1表示指向前驱结点
    private int leftType;
    //0表示指向右子树，1表示指向后继结点
    private int rightType;

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

    /**
     * 递归删除结点
     * 如果删除的是叶子结点，则删除结点；如果是非叶子结点，则删除该子树。
     * <p>
     * 思路：
     * 二叉树是单向的，所以需要判断当前结点的子结点是否需要删除，而不是当前结点是否要删除
     * 1.如果当前节点不为空，并且左节点就是要删除的结点，那么this.left = null,并且return，结束递归
     * 2.如果当前节点不为空，并且右节点就是要删除的结点，那么this.right = null,并且return，结束递归
     * 3.如果步骤1 、2没有删除，则进行左子树的递归删除
     * 4.如果步骤3没有删除，则进行右子树的递归删除
     */
    public void deleteNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if (this.left != null) this.left.deleteNode(no);

        if (this.right != null) this.right.deleteNode(no);
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

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
}