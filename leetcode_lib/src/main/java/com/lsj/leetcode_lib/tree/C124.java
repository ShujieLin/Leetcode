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
        int maxPathSum = new Solution2().maxPathSum(node2);
        System.out.println("maxPathSum = " + maxPathSum);
    }

    static class Solution {
        private int res;

        public int maxPathSum(TreeNode root) {
            res = 0;
            return traverse(root);
        }

        private int traverse(TreeNode root) {
            if (root == null) return 0;
            //System.out.println("-> root = "  +root.val);
            System.out.printf("root : %s -> left \n" , root.val);
            int left = traverse(root.left);
            System.out.printf("root  <- left : %s \n", left);
            System.out.printf("root : %s -> right \n" , root.val);
            int right = traverse(root.right);
            System.out.printf("root  <- right : %s \n", right);
            //res = Math.max(left + right + root.val, res);
            //System.out.printf("<- res = %s \n", res + root.val);
            return res;
        }
    }


    static class Solution2 {
        int res = Integer.MIN_VALUE;

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
            int leftMaxSum = Math.max(0, oneSideMax(root.left));
            int rightMaxSum = Math.max(0, oneSideMax(root.right));
            // 后序遍历位置，顺便更新最大路径和
            int pathMaxSum = root.val + leftMaxSum + rightMaxSum;
            System.out.println("pathMaxSum = " + pathMaxSum + " res = " + res);
            res = Math.max(res, pathMaxSum);
            // 实现函数定义，左右子树的最大单边路径和加上根节点的值
            // 就是从根节点 root 为起点的最大单边路径和
            return Math.max(leftMaxSum, rightMaxSum) + root.val;
        }
    }
}