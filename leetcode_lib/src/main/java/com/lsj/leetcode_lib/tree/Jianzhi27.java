package com.lsj.leetcode_lib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: linshujie
 */
public class Jianzhi27 {
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

        TreeNode node2 = new TreeNode(-2,null,new TreeNode(-3));
        new Solution().pathSum(node2, -5);
    }

    static class Solution {

        private List<List<Integer>> res;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            res = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            backStack(root,targetSum,path);
            return res;
        }

        private void backStack(TreeNode root, int targetSum, LinkedList<Integer> path) {
            if (root == null) return ;

            //先计算当前结点是否为零，判断同时是否为叶子结点，同时满足，可以判断为指定的路径
            int remain = targetSum - root.val;
            System.out.println("remain = " + remain);
/*
            if (remain < 0) return;
*/

            //触底
            if (remain == 0 && root.left == null && root.right == null){
                path.add(root.val);
                res.add(new LinkedList<>(path));
                System.out.println("触底" + Arrays.toString(path.toArray()));
                path.removeLast();
                return;
            }

            //回溯左右
            path.add(root.val);
            System.out.println(" -> " + Arrays.toString(path.toArray()));
            backStack(root.left,remain, path);
            path.removeLast();

            path.add(root.val);
            backStack(root.right,remain, path);
            System.out.println(" <- " + Arrays.toString(path.toArray()));
            path.removeLast();
        }
    }

}
