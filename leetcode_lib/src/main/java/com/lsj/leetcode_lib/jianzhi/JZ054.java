package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;
import com.lsj.leetcode_lib.tree.Utils;

/**
 * @author linshujie
 */
public class JZ054 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(
                4,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2,
                                null,
                                new TreeNode(3))),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7,
                                null,
                                new TreeNode(8)))
        );

        //Utils.infixTraverse(node);
        //Utils.postTraverse(node);
        TreeNode res = new Solution().convertBST(node);
        Utils.infixTraverse(res);
    }

    static class Solution {
        private int cur = 0;
        public TreeNode convertBST(TreeNode root) {
            if (root == null) return null;
            convertBST(root.right);
            cur += root.val;
            System.out.println("cur = " + cur + " root =" + root.val);
            root.val = cur;
            convertBST(root.left);
            return root;
        }
    }
}
