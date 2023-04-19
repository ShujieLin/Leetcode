//package com.lsj.leetcode_lib.tree;
//
///**
// * @author linshujie
// */
//public class Chapter543 {
//    public static void main(String[] args) {
////        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
//
//        int diameter = new Solution().diameterOfBinaryTree(node);
//        System.out.println("diameter = " + diameter);
//
//    }
//
//    static class Solution {
//
//        public int diameterOfBinaryTree(TreeNode root) {
//            int leftDepth = traverse(root.left);
//            int rightDepth = traverse(root.right);
//            System.out.println("rightDepth = " + rightDepth);
//            System.out.println("leftDepth = " + leftDepth);
//            return Math.max(leftDepth, rightDepth);
//        }
//
//        private int traverse(TreeNode root) {
//            if (root == null) return 0;
//            int leftDepth = maxDepth(root.left);
//            int rightDepth = maxDepth(root.right);
//            return Math.max(leftCount, rightCount);
//        }
//
//        private int maxDepth(TreeNode treeNode) {
//            if (treeNode == null) return 0;
//            int left = maxDepth(treeNode.left);
//            int right = maxDepth(treeNode.right);
//            return Math.max(left,right);
//        }
//    }
//}
