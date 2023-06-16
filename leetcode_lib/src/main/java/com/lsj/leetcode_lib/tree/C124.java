package com.lsj.leetcode_lib.tree;

/**
 * &#064;author:  linshujie
 */
public class C124 {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode node2 = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        TreeNode node3 = new TreeNode(9,
                new TreeNode(6),
                new TreeNode(-3,
                        new TreeNode(-6),
                        new TreeNode(2,
                                new TreeNode(2,
                                        new TreeNode(-6,
                                                new TreeNode(-6), null),
                                        new TreeNode(-6)),
                                null)));
        TreeNode node4 = new TreeNode(-1);
        int maxPathSum = new Solution().maxPathSum(node4);

        System.out.println("maxPathSum = " + maxPathSum);
    }

    static class Solution {
        private int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            traverse(root);
            return res;
        }

        private int traverse(TreeNode root) {
            if (root == null) return 0;
            System.out.println(" -> root:" + root.val);
            //与0对比，假如节点是负数，结果肯定不包含他，会缩小最大值
            int leftMax = Math.max(0, traverse(root.left));
            int rightMax = Math.max(0, traverse(root.right));
            System.out.println("leftMax = " + leftMax);
            System.out.println("rightMax = " + rightMax);
            //后序遍历进行计算最大值
            res = Math.max(res, leftMax + rightMax + root.val);
            System.out.println(" <- ");
            //每次遍历节点，返回的是单边的最大值
            return Math.max(leftMax, rightMax) + root.val;
        }
    }


    static class Solution2 {
        int res = Integer.MIN_VALUE;

        /**
         * 只要正数，不要负数，可以是的总大小最大化。
         *
         * @param root
         * @return
         */
        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 计算单边路径和时顺便计算最大路径和
            oneSideMax(root);
            return res;
        }

        // 定义：计算从根节点 root 为起点的最大单边路径和
        int oneSideMax(TreeNode root) {
            if (root == null) {
                return 0;
            }
            System.out.println("-> root :" + root.val);
            //假如是节点小于零，还不如空节点，空节点总大小为零。拿每个左右节点和空节点对比
            int leftMaxSum = Math.max(0, oneSideMax(root.left));
            int rightMaxSum = Math.max(0, oneSideMax(root.right));
           /* int leftMaxSum = oneSideMax(root.left);
            int rightMaxSum =oneSideMax(root.right);*/
            System.out.println("leftMaxSum = " + leftMaxSum);
            System.out.println("rightMaxSum = " + rightMaxSum);
            // 后序遍历位置，顺便更新最大路径和
            int pathMaxSum = root.val + leftMaxSum + rightMaxSum;
//            System.out.println("pathMaxSum = " + pathMaxSum + " res = " + res);
            res = Math.max(res, pathMaxSum);
            System.out.println("<-");
            // 实现函数定义，左右子树的最大单边路径和加上根节点的值
            // 就是从根节点 root 为起点的最大单边路径和
            return Math.max(leftMaxSum, rightMaxSum) + root.val;
        }
    }
}