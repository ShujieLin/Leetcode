package com.lsj.leetcode_lib.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author linshujie
 */
public class C1110 {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1,
                new TreeNode(2, //左子树
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,//右子树
                        new TreeNode(6),
                        new TreeNode(7)));
        List<TreeNode> list = new Solution2().delNodes(node, new int[]{3, 5});

    }

    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            return null;
        }
    }


    static class Solution2 {
        Set<Integer> delSet = new HashSet<>();
        // 记录森林的根节点
        List<TreeNode> res = new LinkedList<>();

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            if (root == null) return new LinkedList<>();
            for (int d : to_delete) {
                delSet.add(d);
            }
            doDelete(root, false);
            return res;
        }

        // 定义：输入一棵二叉树，删除 delSet 中的节点，返回删除完成后的根节点
        private TreeNode doDelete(TreeNode root, boolean hasParent) {
            if (root == null) {
                return null;
            }
            System.out.println("pre = " + root.val);
            // 判断是否需要被删除
            boolean deleted = delSet.contains(root.val);
            if (!deleted && !hasParent) {
                // 没有父节点且不需要被删除，就是一个新的根节点
                res.add(root);
                System.out.println("添加 = " + root.val);
            }
            // 去左右子树进行删除
            root.left = doDelete(root.left, !deleted);
            root.right = doDelete(root.right, !deleted);
            System.out.println(" post = " + root.val + " left = " + root.left + " right = " + root.right );

            // 如果需要被删除，返回 null 给父节点
            return deleted ? null : root;
        }
    }
}