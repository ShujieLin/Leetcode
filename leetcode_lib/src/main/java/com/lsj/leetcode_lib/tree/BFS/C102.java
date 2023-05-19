package com.lsj.leetcode_lib.tree.BFS;

import com.lsj.leetcode_lib.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: linshujie
 */
public class C102 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> lists = new Solution().bfs(node);
        for (List<Integer> list :
                lists) {
            System.out.println("Arrays.toString(list) = " + Arrays.toString(list.toArray()));
        }
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            return bfs(root);
        }

        private List<List<Integer>> bfs(TreeNode root) {
            List<List<Integer>> resList = new LinkedList<>();
            if (root == null) return resList;

            //队列，核心容器
            Queue<TreeNode> q = new LinkedList<>();
            //存放结果
            q.offer(root);
            //循环遍历
            while (!q.isEmpty()) {
                //获取每一层的数量
                int size = q.size();
                List<Integer> list = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    //把这一层的所有节点都取出来，一一向下遍历
                    TreeNode cur = q.poll();
                    list.add(cur.val);
                    System.out.println("cur = " + cur.val);

                    if (cur.left != null) q.offer(cur.left);

                    if (cur.right != null) q.offer(cur.right);
                }
                //遍历完一层
                resList.add(list);
            }

            return resList;
        }
    }
}
