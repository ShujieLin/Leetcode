package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class Jianzhi27 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4, new TreeNode(2,
                new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
//        Utils.preTraverse(node);

        TreeNode mirrorTree = new Solution().mirrorTree(node);
        Utils.preTraverse(mirrorTree);


    }

    static class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            return travserse(root);
        }

        private TreeNode travserse(TreeNode root) {
            if (root == null) return null;
            TreeNode left = travserse(root.left);
            TreeNode right = travserse(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}