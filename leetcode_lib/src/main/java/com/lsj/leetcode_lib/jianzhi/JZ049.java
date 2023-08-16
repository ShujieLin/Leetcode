package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;

import com.lsj.leetcode_lib.tree.Utils;

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
            return  dfs(root, "");
        }

        private int dfs(TreeNode root, String s) {
            if (root == null) return 0;

            String cur = s + root.val;
            if (root.left == null && root.right == null) {
                System.out.println("cur = " + cur);
                return Integer.parseInt(cur);
            }
            //前序遍历获取所有值
            //参数保存着上面结点的值
            int left = dfs(root.left, cur);
            int right = dfs(root.right, cur);

            //后序遍历进行累加
            return left + right;
        }
    }
}
