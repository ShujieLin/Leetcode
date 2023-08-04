package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * @author: linshujie
 */
public class JZ26 {
    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution2 {
        public boolean isSubStructure(TreeNode A, TreeNode B) {

            //递归
            //在树 A 中找到与树 B 根节点相同的节点。
            if (isSubStructure(A, B)){

            }

            //从找到的节点开始判断以该节点为根的子树是否与树 B 相同。
            return false;
        }

        private void isRoot(TreeNode a, TreeNode b) {

        }
    }

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }
            return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean isSubTree(TreeNode A, TreeNode B) {
            if (B == null) {
                return true; // 空树是任意树的子结构
            }
            if (A == null || A.val != B.val) {
                return false;
            }
            return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
        }
    }
}
