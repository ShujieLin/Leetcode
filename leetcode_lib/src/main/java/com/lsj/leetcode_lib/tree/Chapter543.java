package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class Chapter543 {
    public static void main(String[] args) {
//        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

        /*int diameter = new Solution().diameterOfBinaryTree(node);
        System.out.println("diameter = " + diameter);*/

        new Solution().maxDepth(node);
    }

    static class Solution {
        int result = 0;
        /**
         * 所谓二叉树的直径，就是左右子树的最大深度之和，那么直接的想法是对每个节点计算左右子树的最大高度，得出每个节点的直径，从而得出最大的那个直径。
         * @param root
         * @return
         */
        public int diameterOfBinaryTree(TreeNode root) {

            return 0;
        }

        int maxDepth(TreeNode node){
            if (node == null) return 0;
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);
            System.out.println("rightDepth = " + rightDepth);
            System.out.println("leftDepth = " + leftDepth);

            return 1 + Math.max(leftDepth , rightDepth);

        }

    }
}
