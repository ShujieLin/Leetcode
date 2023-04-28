package com.lsj.leetcode_lib.tree.BST;

import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * @author: linshujie
 */
public class Chapter230 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3,new TreeNode(1,null,new TreeNode(2)),new TreeNode(4));
        int kthSmallest = new Solution().kthSmallest(treeNode, 1);
        System.out.println("kthSmallest = " + kthSmallest);
    }

    static class Solution {
        public int kthSmallest(TreeNode root, int k) {
            traverse(root,k);
            return resValue;
        }

        int count = 0,//第几个
                resValue = 0;//当前计数的结果值
        private void traverse(TreeNode root,int k){
            if (root == null) return;
            traverse(root.left,k);
            if (count < k){
                count ++;
                resValue = root.val;
            }
            traverse(root.right,k);
        }
    }
}