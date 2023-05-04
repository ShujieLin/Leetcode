package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class Test {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        System.out.println(" 前序 " );
        Utils.preTraverse(root);

        System.out.println(" 中序 " );
        Utils.infixTraverse(root);

        System.out.println(" 后序 ");
        Utils.postTraverse(root);
    }
}
