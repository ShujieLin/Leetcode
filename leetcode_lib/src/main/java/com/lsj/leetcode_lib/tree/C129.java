package com.lsj.leetcode_lib.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: linshujie
 */
public class C129 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4,
                new TreeNode(9,
                        new TreeNode(5),
                        new TreeNode(1)),
                new TreeNode(0));
        new Solution().sumNumbers(node);
    }

    static class Solution {

        private List<String> list;

        public int sumNumbers(TreeNode root) {

            list = new ArrayList<>();
            traverse(root, new StringBuilder());
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                res += Integer.valueOf(list.get(i));
            }
            System.out.println("res = " + res);
            return res;
        }

        //遍历
        private int traverse(TreeNode root, StringBuilder sb) {
            if (root == null) return 0;
            sb.append(root.val);
            System.out.println("sb = " + sb.toString());
            if (root.left == null && root.right == null) {
                list.add(sb.toString());
                System.out.println("add " + sb.toString());
            }
            traverse(root.left, sb);
            traverse(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(" <- ");
            return 0;
        }

    }
}