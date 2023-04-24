package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class Chapter226 {
    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode node = null;
        Utils.traverse(node);
        TreeNode treeNode = new Solution().invertTree(node);
        System.out.println(" ===================== ");
        Utils.traverse(treeNode);
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            return traverse(root);
        }

        TreeNode traverse(TreeNode root) {
            if (root == null) return null;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            traverse(root.left);
            traverse(root.right);
            return root;
        }
    }

    static class Solution2 {
        /**
         * 直接转换
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            TreeNode left = invertTree(root.left);//传子结点进去，返回的也是子结点
            TreeNode right = invertTree(root.right);

            //遍历到最底部的结点，进行递归返回的时候，把所有结点的左右子节点进行交换。
            root.left = right;
            root.right = left;
            return root;
        }
    }
}