 package com.lsj.leetcode_lib.tree;

import java.util.ArrayList;
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
        new Solution2().pathSum(treeNode, 22);
    }

    static class Solution2 {
        private List<List<Integer>> res;

        /**
         * 思路：回溯
         * 记录当前路径：path
         * 选择列表：left right
         * 触底，添加到目标容器
         *
         * @param root
         * @param targetSum
         * @return
         */
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            res = new LinkedList<>();

            LinkedList<Integer> path = new LinkedList<>();
            backstack(root, path, targetSum);
            return res;
        }

        private void backstack(TreeNode root, LinkedList<Integer> path, int targetSum) {
            if (root == null) return;

            int remain = targetSum - root.val;
            //触底判断
            if (root.left == null && root.right == null) {
                if (remain == 0) {
                    //触底
                    //添加当前节点
                    path.addLast(root.val);
                    System.out.println(" -> " + Arrays.toString(path.toArray()));
                    System.out.println(" 触底 " );
                    res.add(new LinkedList<>(path));
                    path.removeLast();
                    System.out.println(" <- " + Arrays.toString(path.toArray()));
                }
                return;
            }

            //回溯
            path.addLast(root.val);
            System.out.println(" -> " + Arrays.toString(path.toArray()));
            backstack(root.left, path, remain);
            path.removeLast();
            System.out.println(" <- " + Arrays.toString(path.toArray()));

            //回溯右子树
            path.addLast(root.val);
            System.out.println(" -> " + Arrays.toString(path.toArray()));
            backstack(root.right, path, remain);
            path.removeLast();
            System.out.println(" <- " + Arrays.toString(path.toArray()));

        }
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

                    System.out.println(" 触底 ");
                    // 找到一条路径，需要注意的是这时候进入到当前的结点，需要把当前这个结点的添加到当前路径中去。
                    path.addLast(root.val);
                    System.out.println("-> " + Arrays.toString(path.toArray()));
                    res.add(new LinkedList<>(path));

                    path.removeLast();
                    System.out.println(" <-" + Arrays.toString(path.toArray()));

                }
                return;
            }

            // 维护路径列表
            path.addLast(root.val);
            System.out.println("-> " + Arrays.toString(path.toArray()));
            traverse(root.left, remain, path);
            path.removeLast();
            System.out.println(" <-" + Arrays.toString(path.toArray()));

            path.addLast(root.val);
            System.out.println("-> " + Arrays.toString(path.toArray()));
            traverse(root.right, remain, path);
            path.removeLast();
            System.out.println(" <-" + Arrays.toString(path.toArray()));
        }
    }
}