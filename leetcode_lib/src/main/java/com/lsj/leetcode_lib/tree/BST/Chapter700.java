package com.lsj.leetcode_lib.tree.BST;

import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * @author linshujie
 */
public class Chapter700 {

    public static void main(String[] args) {

    }

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            return traverse(root, val);
        }

        private TreeNode traverse(TreeNode root, int val) {
            if (root == null) return null;
            if (root.val == val) return root;

            TreeNode left = traverse(root.left, val);
            TreeNode right = traverse(root.right, val);
            return left == null ? right : left;
        }
    }

    class Solution2 {
        public TreeNode searchBST(TreeNode root, int val) {
            return traverse(root, val);
        }

        private TreeNode traverse(TreeNode root, int val) {
            if (root == null) return null;
            //搜索树左小右大
            if (val > root.val){
                return traverse(root.right, val);//不需要穷举所有的结点
            }
            if (val < root.val){
                return traverse(root.left,val);
            }
            return root;
        }
    }
}
