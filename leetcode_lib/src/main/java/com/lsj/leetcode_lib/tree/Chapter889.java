package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class Chapter889 {
    class Solution {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        TreeNode build(int[] preorder, int startPre, int endPre, int[] postorder, int postStart, int postEnd) {
            if (startPre > endPre) return null;
            if (startPre == endPre) return new TreeNode(preorder[startPre]);

            int rootValue = preorder[startPre];
            //拿到postorder左子树的右边界
            int leftRoot = preorder[startPre + 1];
            //遍历查找postorder的leftroot
            int index = 0;
            for (int i = 0; i < postorder.length; i++) {
                if (postorder[i] == leftRoot) {
                    index = i;
                }
            }
            int leftSize = index - postStart + 1;
            TreeNode root = new TreeNode(rootValue);
            root.left = build(preorder, startPre + 1, startPre + leftSize, postorder, postStart, postStart + leftSize - 1);
            root.right = build(preorder, startPre + leftSize + 1, endPre, postorder, index + 1, postEnd - 1);
            return root;
        }
    }
}