package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author linshujie
 */
public class JZ045 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3,
                        new TreeNode(5, new TreeNode(7), null),
                        new TreeNode(6))
        );
        TreeNode nodeEdge = new TreeNode(1);
        int res = new Solution().findBottomLeftValue(nodeEdge);
        System.out.println("res = " + res);
    }

    static class Solution {

        private List<List<Integer>> res;

        public int findBottomLeftValue(TreeNode root) {
            bfs(root);
            for (List<Integer> list :
                    res) {
                System.out.println("list = " + Arrays.toString(list.toArray()));
            }
            int target = res.get(res.size() - 1).get(0);
            System.out.println("target = " + target);
            return target;
        }

        private void bfs(TreeNode root) {
            if (root == null) return;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            res = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    list.add(cur.val);
                    System.out.println("cur.val = " + cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                res.add(list);
                System.out.println("- - ");
            }
        }
    }
}