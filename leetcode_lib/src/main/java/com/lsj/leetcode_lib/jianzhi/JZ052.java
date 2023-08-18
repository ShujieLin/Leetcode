package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;
import com.lsj.leetcode_lib.tree.Utils;

/**
 * @author linshujie
 */
public class JZ052 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(
                5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(6,
                        null,
                        new TreeNode(8,
                                new TreeNode(7),
                                new TreeNode(9)))
        );
        /*Utils.infixTraverse(node);*/
        TreeNode res = new Solution().increasingBST(node);
        Utils.preTraverse(res);
    }

    static class Solution {
        private TreeNode cur;

        public TreeNode increasingBST(TreeNode root) {
            TreeNode newNode;
            cur = new TreeNode(-1);
            newNode = cur;
            dfs(root);
            return newNode.right;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);

            //新建一棵树
            cur.right = new TreeNode(root.val);
            cur = cur.right;

            dfs(root.right);
        }
    }
}