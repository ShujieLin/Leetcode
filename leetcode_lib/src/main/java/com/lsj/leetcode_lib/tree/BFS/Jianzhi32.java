package com.lsj.leetcode_lib.tree.BFS;

import com.lsj.leetcode_lib.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: linshujie
 */
public class Jianzhi32 {

    public static void main(String[] args) {

    }

    class Solution {
        public int[] levelOrder(TreeNode root) {
            return bfs(root);
        }

        private int[] bfs(TreeNode root) {
            if (root == null) return new int[]{};
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    res.add(cur.val);

                    if (cur.left != null) {
                        q.offer(cur.left);
                    }

                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
            }

            int[] resArray = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                resArray[i] = res.get(i);
            }

            return resArray;
        }
    }
}