package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class Utils {
    public static void traverse(TreeNode root){
        if (root == null) return;
        System.out.println("root = " + root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
