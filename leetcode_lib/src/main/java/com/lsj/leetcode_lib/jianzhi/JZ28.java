package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * @author linshujie
 */
public class JZ28 {
    public static void main(String[] args) {

    }

    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            //判断左右子树
            return isSubNodeSymmetric(root.left, root.right);
        }

        private boolean isSubNodeSymmetric(TreeNode left, TreeNode right) {
            //都是空
            if (left == null && right == null) return true;
            //其中一个是空
            if (left == null || right == null) return false;
            //值不一样
            if (left.val != right.val) return false;
            return isSubNodeSymmetric(left.left, right.right) && isSubNodeSymmetric(left.right,
                    right.left);
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 断一棵二叉树是否是对称的，可以使用递归来解决。如果一棵二叉树是对称的，那么它的左子树和右子树也必须是对称的，并且它们的镜像也必须相同。
         *
         * 具体思路如下：
         *
         * 编写一个递归函数 isSymmetricTree，接受两个节点 left 和 right 作为参数，分别表示左子树和右子树的根节点。
         *
         * 在递归函数中，判断以下条件：
         *
         * 如果 left 和 right 都为 null，则返回 true，因为空树是对称的。
         * 如果 left 或 right 中有一个为 null，另一个不为 null，则返回 false，因为对称树的左右子树节点数不等。
         * 如果 left 和 right 的值不相等，返回 false，因为对称树节点的值要相等。
         * 否则，继续递归判断 left 的左子树和 right 的右子树是否对称，以及 left 的右子树和 right 的左子树是否对称。
         * 最终，判断整棵树是否是对称的，调用 isSymmetricTree(root.left, root.right)。
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return false;

            return isSymmetricTree(root.left, root.right);
        }

        private boolean isSymmetricTree(TreeNode left, TreeNode right) {
            //子问题
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //递归，分解问题
            return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right,
                    right.left);
        }
    }
}
