package com.lsj.leetcode_lib.tree.BST;

import com.lsj.leetcode_lib.tree.TreeNode;
import com.lsj.leetcode_lib.tree.Utils;

/**
 * @author linshujie
 */
public class Chapter538 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3,
                new TreeNode(2, new TreeNode(1), null),
                new TreeNode(4));

        TreeNode node2 = new TreeNode(4,
                new TreeNode(1, new TreeNode(0), new TreeNode(2,null,new TreeNode(3))),
                new TreeNode(6,new TreeNode(5),new TreeNode(7,null,new TreeNode(8))));


        Utils.infixTraverse(node2);
        System.out.println("============");
        Utils.infixTraverseReverse(node2);

        /*Utils.infixTraverse(node2);
        TreeNode treeNode = new Solution().convertBST(node2);
        Utils.infixTraverse(treeNode);*/
    }

    static class Solution {
        int res = 0;

        public TreeNode convertBST(TreeNode root) {
            traverse(root);
            return root;
        }

        /**
         * 降序
         *
         * @param root
         * @return
         */
        private void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.right);
            res += root.val;
            root.val = res;
            traverse(root.left);
        }
    }
}