package com.shujie.datastructure.tree.binarysorttree;

/**
 * @author: linshujie
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        binarySortTree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;

    public Node search(int value) {
        if (root == null) return null;
        else return root.search(value);
    }

    public Node searchParent(int value) {
        if (root == null) return null;
        else return root.searchParent(value);
    }

    public int delRightTreeMin(Node node){
        Node target = node;
        //循环查找左节点，就会找到最小值
        while (target.left != null){
            target = target.left;
        }
        //删除最小节点
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value){
        if (root == null) return;
        else {
            //找到要删除的节点
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }
            //如果发现当前二叉排序树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //找targetNode父结点
            Node parent = searchParent(value);
            //如果删除的是叶子结点
            if (targetNode.left == null && targetNode.right == null){
                //判断targetNode是父结点的左子结点还是右子节点
                if (parent.left != null && parent.left.value ==value){
                    parent.left = null;
                }else if (parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right !=null){//有两颗字树
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else {//只有一颗字树
                if (targetNode.left!=null ){
                    if (parent.left.value == value){
                        parent.left = targetNode.left;
                    }else {
                        parent.right = targetNode.left;
                    }
                }else {//只有右子树
                    if (parent.left.value == value){
                        parent.left = targetNode.right;
                    }else {
                        parent.right = targetNode.right;
                    }
                }
            }
        }
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("root is null");
        }
    }
}

class Node {
    int value;
    Node right;
    Node left;

    public Node(int value) {
        this.value = value;
    }

    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) return null;
            return this.left.search(value);
        } else {
            if (this.right == null) return null;
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除结点的父结点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        //
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {//没有父结点
                return null;
            }
        }
    }

    public void add(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

}
