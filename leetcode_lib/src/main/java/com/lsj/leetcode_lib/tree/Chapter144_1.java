package com.lsj.leetcode_lib.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2022/6/15
 * @author: linshujie
 */
public class Chapter144_1 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            //使用容器装树节点
            List<Integer> list = new ArrayList<>();

            //递归遍历树
            recursion(root,list);

            return list;
        }

        private void recursion(TreeNode root, List<Integer> list) {
            if (root == null) return;

            list.add(root.val);
            recursion(root.left,list);
            recursion(root.right,list);
        }
    }

}
