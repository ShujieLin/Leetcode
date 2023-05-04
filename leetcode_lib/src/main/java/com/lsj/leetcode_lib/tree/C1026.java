package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class C1026 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8, new TreeNode(3), new TreeNode(10));
        new Solution().maxAncestorDiff(treeNode);
    }

    /**
     * 后续遍历
     * 假如为零返回
     * 找到root 和left的差值；找到root和right的差值，对比差值之间的大小
     * return 两个数，一个是maxvalue，一个是minvalue
     */
     static class Solution {
        public int maxAncestorDiff(TreeNode root) {
            traverse(root);
            return res;
        }

        int res = 0;

        /**
         * 返回根结点最大值和最小值
         *
         * @param root
         * @return 第一个元素为最小值，第二个元素为最大值
         */
        private int[] traverse(TreeNode root) {
            if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

            //后序遍历
            //找到左边最大值和最小值
            int[] leftMinMax = traverse(root.left);
            //找到右边最大值和最小值
            int[] rightMinMax = traverse(root.right);

            //找到当前最大值
            int max = maxValue(root.val, leftMinMax[1], rightMinMax[1]);
            //找到当前最小值
            int min = minValue(root.val, leftMinMax[0], rightMinMax[0]);
            System.out.println("min = " + min);
            System.out.println("max = " + max);

            //差值
            //更新结果值：最大差值
            res = maxValue(res, root.val - min, max - root.val);
            System.out.println("res = " + res);

            return new int[]{min, max};
        }

        private int maxValue(int a, int b, int c) {
            return Math.max(a, Math.max(b, c));
        }

        private int minValue(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }

    static class Solution2 {
        public int maxAncestorDiff(TreeNode root) {
            getMinMax(root);
            return res;
        }

        int res = 0;

        // 定义：输入一棵二叉树，返回该二叉树中节点的最小值和最大值，
        // 第一个元素是最小值，第二个值是最大值
        int[] getMinMax(TreeNode root) {
            if (root == null) {
                return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
            }
            int[] leftMinMax = getMinMax(root.left);
            int[] rightMinMax = getMinMax(root.right);
            // 以 root 为根的这棵树的最大值和最小值可以通过左右子树的最大最小值推导出来
            int rootMin = min(root.val, leftMinMax[0], rightMinMax[0]);
            int rootMax = max(root.val, leftMinMax[1], rightMinMax[1]);
            // 在后序位置顺便判断所有差值的最大值
            res = max(res, rootMax - root.val, root.val - rootMin);

            return new int[]{rootMin, rootMax};
        }

        int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }

        int max(int a, int b, int c) {
            return Math.max(Math.max(a, b), c);
        }
    }
}