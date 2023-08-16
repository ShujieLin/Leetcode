package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * @author linshujie
 */
public class JZ50 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(
                10,
                new TreeNode(5,
                        new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3,
                        null,
                        new TreeNode(11))
        );

        TreeNode node2 = new TreeNode(1,
                new TreeNode(-2,
                        new TreeNode(1,
                                new TreeNode(-1),
                                null),
                        new TreeNode(3)),
                new TreeNode(-3,
                        new TreeNode(-2), null));

        int sum = new Solution().pathSum(node2, -1);
        System.out.println("sum = " + sum);

        //715827882
        //2147483647
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
    }

    static class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            int curSum = dfs(root, targetSum);
            int left = pathSum(root.left, targetSum);
            int right = pathSum(root.right, targetSum);
            return curSum + left + right;
        }

        private int dfs(TreeNode root, int targetSum) {
            if (root == null) return 0;
            int curTraget = targetSum - root.val;
            //问题在于，没有吧count和递归dfs累加，导致少了
            int count = 0;
            if (curTraget == 0) {
                count++;
            }
            //System.out.println("root = " + root.val + " cur = " + curTraget);
            count += dfs(root.left, curTraget);
            count += dfs(root.right, curTraget);
            return count;
        }

       /* private int dfs(TreeNode root, int targetSum) {
            if (root == null) return 0;
            int curTraget = targetSum - root.val;
            //问题在于，没有
            int count = 0;
            if (curTraget == 0) {
                count++;
                return count;
            }
            //System.out.println("root = " + root.val + " cur = " + curTraget);
            int left = dfs(root.left, curTraget);
            int right = dfs(root.right, curTraget);
            return left + right;
        }*/
    }
}
