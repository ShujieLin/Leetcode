package com.lsj.leetcode_lib.tree.BST;

import com.lsj.leetcode_lib.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linshujie
 */
public class Chapter95 {
    public static void main(String[] args) {
        List<TreeNode> list = new Solution().generateTrees(3);
    }

    static class Solution {

        public List<TreeNode> generateTrees(int n) {
            return traverse(1, n);
        }

        private List<TreeNode> traverse(int low, int high) {
            List<TreeNode> list = new LinkedList<>();
            if (low > high){
                list.add(null);
                return list;
            }

            for (int i = low; i <= high; i++) {
                //i作为root
                List<TreeNode> left = traverse(low, i - 1);
                List<TreeNode> right = traverse(i + 1, high);
                //构建树
                for (TreeNode leftNode : left) {
                    for (TreeNode rightNode : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        list.add(root);
                    }
                }
            }
            return list;
        }
    }
}