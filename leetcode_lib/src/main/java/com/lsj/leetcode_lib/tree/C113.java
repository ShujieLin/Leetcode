package com.lsj.leetcode_lib.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linshujie
 */
public class C113 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7), new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5), new TreeNode(1))));
        new Solution().pathSum(treeNode, 22);
    }

    static class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) return res;
            traverse(root, sum, new LinkedList<>());
            return res;
        }

        // 遍历二叉树
        private void traverse(TreeNode root, int sum, LinkedList<Integer> path) {
            if (root == null) return;

            int remain = sum - root.val;

            if (root.left == null && root.right == null) {
                if (remain == 0) {
                    // 找到一条路径
                    path.addLast(root.val);
                    res.add(new LinkedList<>(path));
                    path.removeLast();
                }
                return;
            }

            // 维护路径列表
            path.addLast(root.val);
            System.out.println("left addLast = " + root.val + "  " + Arrays.toString(path.toArray()));
            traverse(root.left, remain, path);
            path.removeLast();
            System.out.println("left removeLast = " + root.val + "  " + Arrays.toString(path.toArray()));

            path.addLast(root.val);
            System.out.println("right addLast = " + root.val + "  " + Arrays.toString(path.toArray()));
            traverse(root.right, remain, path);
            path.removeLast();
            System.out.println("right removeLast = " + root.val + "  " + Arrays.toString(path.toArray()));
        }
    }
}