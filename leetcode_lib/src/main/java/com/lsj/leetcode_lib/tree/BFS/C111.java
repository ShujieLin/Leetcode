package com.lsj.leetcode_lib.tree.BFS;

import com.lsj.leetcode_lib.tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author linshujie
 */
public class C111 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2), null);

        int minDepth = new Solution().minDepth(null);
        System.out.println("minDepth = " + minDepth);
    }

    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            //队列
            Queue<TreeNode> queue = new LinkedList<>();
            //记录路径
            /*Set<TreeNode> path = new HashSet<>();*/
            //深度
            int depth = 1;
            queue.offer(root);
            //循环，用于遍历每一层
            while (!queue.isEmpty()) {
                //拿到当前这一层有多少个节点
                int size = queue.size();
                //遍历这一层的所哟节点
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    //判断是否时叶子节点
                    if (cur.left == null && cur.right == null) {
                        return depth;
                    }

                    //将相邻节点加入队列
                    if (cur.left != null) queue.offer(cur.left);

                    if (cur.right != null) queue.offer(cur.right);
                }

                //每一层，增加一次深度
                depth++;
            }

            return depth;
        }
    }
}
