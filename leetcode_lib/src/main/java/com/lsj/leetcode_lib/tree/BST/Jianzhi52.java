package com.lsj.leetcode_lib.tree.BST;

import com.lsj.leetcode_lib.tree.TreeNode;
import com.lsj.leetcode_lib.tree.Utils;

/**
 * @author: linshujie
 */
public class Jianzhi52 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3,
                new TreeNode(2,
                        new TreeNode(1), null),
                new TreeNode(4));
//        Utils.infixTraverse(node);
        new Solution().increasingBST(node);
    }

    static class Solution {
        public TreeNode increasingBST(TreeNode root) {

            return traverse(root);
        }

        private TreeNode traverse(TreeNode root) {
            if (root == null) return null;

            //断开root和它的父结点

            //判断是否存在左节点，存在才需要进行操作
            //让root指向它的左节点
            System.out.println("->" + root.val);
            TreeNode left = traverse(root.left);
            root.left = null;
            System.out.println("--" + root.val);
            TreeNode right = traverse(root.right);
            root.right = right;

            //把root接到它的左节点的右叶子结点
            if (left == null) return root;
            TreeNode p = left;
            while (p.right != null){
                p = p.right;
            }
            p.right = root;

            System.out.println("<-" + root.val);

            return left;
        }
    }
}