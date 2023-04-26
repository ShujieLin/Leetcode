package com.lsj.leetcode_lib.tree;

/**
 * @author: linshujie
 */
public class Chapter106 {

    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            if (postStart > postEnd) return null;

            //找到中序数组的 root的下标
            int rootValue = postorder[postEnd];
            int index = 0;
            for (int i = inStart; i < inEnd; i++) {
                if (postorder[i] == rootValue) {
                    index = i;
                }
            }
            //找到postorder的左右子树起点和终点
            int leftSize = index - inStart;

            TreeNode root = new TreeNode(rootValue);
            build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize);
            build(inorder, index + 1, inEnd, postorder, postStart + leftSize + 1, postEnd - 1);
            return root;
        }
    }
}