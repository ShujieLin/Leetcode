package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: linshujie
 */
public class JZ44 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5),
                        new TreeNode(3)),
                new TreeNode(2,
                        null,
                        new TreeNode(9)));
        List<Integer> list = new Solution().largestValues(null);
        System.out.println("Arrays.toString(list) = " + Arrays.toString(list.toArray()));

        String s1 = "sssa";
        String s2 = "sssa";
        System.out.println("s1.hashCode() = " + s1.hashCode());
        System.out.println("s2.hashCode() = " + s2.hashCode());
    }

    static class Solution {

        private List<Integer> res;

        public List<Integer> largestValues(TreeNode root) {
            res = new ArrayList<>();
            bfs(root);
            return res;
        }

        private void bfs(TreeNode root) {
            if (root == null) return;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int max = Integer.MIN_VALUE;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    max = Math.max(max, cur.val);

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                res.add(max);
            }
        }

    }
}