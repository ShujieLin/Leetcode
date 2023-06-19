package com.lsj.leetcode_lib.tree;

import java.util.HashSet;

/**
 * @author: linshujie
 */
public class C1261 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-1,
                new TreeNode(-1,
                        new TreeNode(-1),
                        new TreeNode(-1)),
                new TreeNode(-1));

        TreeNode node1 = new TreeNode(-1,null,new TreeNode(-1));

        new FindElements(node1);
        Utils.preTraverse(node1);

        boolean b = new FindElements(node1).find(2);
        System.out.println("b = " + b);

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    static class FindElements {
        private final HashSet<Integer> set;

        public FindElements(TreeNode root) {

            //存储节点，便于查找
            set = new HashSet<>();
            traverse(root,0);
        }

        private void traverse(TreeNode root, int value) {
            if (root == null) return;

            root.val = value;
            set.add(root.val);
            traverse(root.left, value * 2 + 1);
            traverse(root.right, value * 2 + 2);
        }


        public boolean find(int target) {
            return set.contains(target);
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}
