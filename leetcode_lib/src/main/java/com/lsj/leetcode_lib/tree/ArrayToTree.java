package com.lsj.leetcode_lib.tree;

/**
 * @author: linshujie
 */
public class ArrayToTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; // Example array representing binary tree

        TreeNode root = new Solution().constructBinaryTree2(arr, 0);

        System.out.println("In-order traversal of constructed binary tree:");

       /* TreeNode node = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7)));*/
        Utils.infixTraverse(root);
    }

    static class Solution {
        TreeNode constructBinaryTree(int[] arr, int i) {
            if (arr == null || i >= arr.length) return null;

            //构建根结点
            TreeNode root = new TreeNode(arr[i]);
            System.out.println("root = " + root.val);
            //构造左节点
            root.left = constructBinaryTree(arr, i * 2 + 1);
            //构造右节点
            root.right = constructBinaryTree(arr, i * 2 + 2);
            return root;
        }

        TreeNode constructBinaryTree2(int[] arr, int index) {
            if (index >= arr.length || arr[index] == -1) {
                return null;
            }

            TreeNode root = new TreeNode(arr[index]);
            root.left = constructBinaryTree2(arr, 2 * index + 1);
            root.right = constructBinaryTree2(arr, 2 * index + 2);

            return root;
        }

    }

}
