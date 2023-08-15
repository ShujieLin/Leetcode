package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;

import java.util.List;

/**
 * @author: linshujie
 */
public class JZ049 {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(4,
                new TreeNode(9,
                        new TreeNode(5),
                        new TreeNode(1)),
                new TreeNode(0));
        int i = new Solution().sumNumbers(node);
        System.out.println("i = " + i);
    }

    static class Solution {
        public int sumNumbers(TreeNode root) {
            dfs(root,"");
            return 0;
        }

        private int dfs(TreeNode root, String path) {
            if (root == null) return 0;

            String curPath = path + root.val;
            if (root.left == null && root.right == null){
                return Integer.parseInt(curPath);
            }

            int left = dfs(root.left, curPath);
            int right = dfs(root.right, curPath);

        }
    }
}
