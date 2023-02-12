package com.shujie.datastructure.tree;

/**
 * @author: linshujie
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        tree.preOrder();
    }
}

class ArrayBinaryTree {
    private final int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    public void preOrder() {
        preOrder(0);
    }

    public void preOrder(int index) {
        if (array == null || array.length == 0) {
            System.out.println("array is null");
            return;
        }

        System.out.println("current num is " + array[index]);

        if (index * 2 + 1 < array.length) {
            preOrder(index * 2 + 1);
        }

        if (index * 2 + 2 < array.length) {
            preOrder(index * 2 + 2);
        }
    }
}