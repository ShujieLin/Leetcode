package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class Utils {
    public static void preTraverse(TreeNode root){
        if (root == null) return;
        System.out.println("root = " + root.val);
        preTraverse(root.left);
        preTraverse(root.right);
    }

    public static void infixTraverse(TreeNode root){
        if (root == null) return;
        infixTraverse(root.left);
        System.out.println("root = " + root.val);
        infixTraverse(root.right);
    }
    public static void postTraverse(TreeNode root){
        if (root == null) return;
        postTraverse(root.left);
        postTraverse(root.right);
        System.out.println("root = " + root.val);
    }
}
