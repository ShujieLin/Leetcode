package com.lsj.leetcode_lib.tree.BST;

import com.lsj.leetcode_lib.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: linshujie
 */
public class C1082 {

    /**
     * 中序遍历获取树的元素
     * 先构造根结点
     * 再构造子结点
     */
    class Solution {

        private List<Integer> list;

        public TreeNode balanceBST(TreeNode root) {
            list = new LinkedList<>();
            infixTraverse(root);

            return build(0, list.size() - 1);
        }

        private TreeNode build(int low, int high) {
            if (low > high) return null;

            int mid = low + (high - low) / 2;
            TreeNode root = new TreeNode(list.get(mid));
            TreeNode left = build(low, mid - 1);
            TreeNode right = build(mid + 1, high);
            root.left = left;
            root.right = right;
            return root;
        }

        private void infixTraverse(TreeNode root) {
            if (root == null) return;
            infixTraverse(root.left);
            list.add(root.val);
            infixTraverse(root.right);
        }
    }
}
