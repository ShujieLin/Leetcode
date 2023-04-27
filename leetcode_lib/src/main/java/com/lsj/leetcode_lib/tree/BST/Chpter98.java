package com.lsj.leetcode_lib.tree.BST;

import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * @author linshujie
 */
public class Chpter98 {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, null, null);
        }

        private boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) return true;

            if (min != null && min.val >= root.val) return false;
            if (max != null && max.val <= root.val) return false;

            //本质就是需要判断：root.left < root < root.right
            // 需要把约束传递下去
            return isValid(root.left, min, root) && isValid(root.right, root, max);
        }
    }
}
