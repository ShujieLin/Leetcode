package com.shujie.datastructure.tree.AVLtreeDemo;

/**
 * @author: linshujie
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
        /*int[] arr = {4, 3, 6, 5, 7, 8};*/
        int[] arr = {10, 12, 8, 9, 7, 6};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("没有平衡前");
        System.out.println("树的高度" + avlTree.root.height());
        System.out.println("左子树的高度" + avlTree.root.left.height());
        System.out.println("右子树的高度" + avlTree.root.right.height());
        System.out.println("根结点 = " + avlTree.root.value);
        System.out.println("根结点的左子结点=" + avlTree.root.left);
    }
}

class AVLTree {
    Node root;

    public Node search(int value) {
        if (root == null) return null;
        else return root.search(value);
    }

    public Node searchParent(int value) {
        if (root == null) return null;
        else return root.searchParent(value);
    }

    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环查找左节点，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //删除最小节点
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value) {
        if (root == null) return;
        else {
            //找到要删除的节点
            Node targetNode = search(value);
            if (targetNode == null) {
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
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode是父结点的左子结点还是右子节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//有两颗字树
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {//只有一颗字树
                if (targetNode.left != null) {
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                } else {//只有右子树
                    if (parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else {
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

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * 返回当前为根结点的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 左旋
     */
    private void leftRotate() {
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;

        //当前结点的右子树设置成当前结点的右子树的右子树
        right = right.right;
        //把当前结点的左子树设置为新的节点
        left = newNode;
    }

    /**
     * 右旋
     */
    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    /**
     * @param value
     * @return
     */
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

        //添加节点后，如果右子树高度大于左子树高度，左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果右子树的左子树的高度大于它的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对右子节点进行右旋转
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }

        if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于它的左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //对当前结点的左子树进行左旋转
                left.leftRotate();
                //在对当前结点进行右旋转
                rightRotate();
            } else {
                rightRotate();
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