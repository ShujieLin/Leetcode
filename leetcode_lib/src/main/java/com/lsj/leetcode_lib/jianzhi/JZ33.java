package com.lsj.leetcode_lib.jianzhi;

/**
 * @author linshujie
 */
public class JZ33 {
    public static void main(String[] args) {

    }

    static class Solution {
        /**
         * 要判断一个数组是否是某个二叉搜索树的后序遍历结果，可以利用二叉搜索树的性质来解决。二叉搜索树（BST）的后序遍历结果中，最后一个元素是根节点，数组中的元素可以分为三个部分：
         *
         * 左子树节点：位于数组左侧，小于根节点的值。
         * 右子树节点：位于数组右侧，大于根节点的值。
         * 根节点：数组的最后一个元素。
         * 根据这个性质，可以通过递归的方式判断数组是否是某个BST的后序遍历结果。
         *
         * 具体思路如下：
         *
         * 定义递归函数 verifyPostorder，接受一个数组 postorder 和区间 [start, end] 作为参数，表示当前子树在数组中的范围。
         *
         * 如果 start >= end，说明当前子树只有一个节点或没有节点，直接返回 true，因为单个节点或空树都是BST。
         *
         * 在数组中找到根节点的值 rootVal，即数组的最后一个元素 postorder[end]。
         *
         * 遍历数组，找到第一个大于 rootVal 的元素的索引 rightChildIndex。此时，rightChildIndex 左侧的元素都属于左子树，右侧的元素都属于右子树。
         *
         * 遍历 rightChildIndex 右侧的元素，如果出现任何一个小于 rootVal 的元素，则返回 false，因为右子树中的所有节点都应该大于根节点。
         *
         * 递归调用 verifyPostorder，判断左子树和右子树是否满足BST的后序遍历条件。
         *
         * 如果左子树和右子树都满足BST的后序遍历条件，返回 true，否则返回 false。
         */
        public boolean verifyPostorder(int[] postorder) {
            //找到根结点，即最后一个元素。
            int root = postorder[postorder.length - 1];

            int rightChildIndex = 0;
            //找到第一个大于root的值，作为root.right,
            for (int i : postorder) {
                if (i > root) {
                    rightChildIndex = i;
                    break;
                }
            }

            //遍历rightChild右侧的所有元素,看看是否都大于根结点
            for (int i = rightChildIndex; i < postorder.length - 1; i++) {
                if (postorder[i] < root) return false;
            }

            return false;
        }
    }
}
