package com.lsj.leetcode_lib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author linshujie
 */
public class C637 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2147483647,
                new TreeNode(2147483647),
                new TreeNode(2147483647,
                        new TreeNode(15),
                        new TreeNode(7)));
        List<Double> list = new Solution().averageOfLevels(node);
        System.out.println("list = " + Arrays.toString(list.toArray()));
    }

    static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res= new ArrayList<>();
            bfs(root,res);
            return res;
        }

        private void bfs(TreeNode root, List<Double> res) {
            if (root == null) return;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                long sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    //System.out.println("cur.val = " + cur.val);
                    sum += cur.val;

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                res.add((double) sum/size);
                //System.out.println(" ---- ");
            }
        }
    }
}
