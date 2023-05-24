package com.lsj.leetcode_lib.tree.BFS;

import com.lsj.leetcode_lib.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author linshujie
 */
public class C863 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6), 
                        new TreeNode(2,
                                new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, 
                        new TreeNode(0), new TreeNode(8)));
        List<Integer> list = new Solution2().distanceK(node, node.left, 2);
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
    }

    static class Solution2 {

        private Map<Integer, TreeNode> parents;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

            return bfs(root, target, k);
        }

        private List<Integer> bfs(TreeNode root, TreeNode target, int k) {
            List<Integer> res = new ArrayList<>();
            //转换为图,树里面没有重复value的节点,可以把value作为key
            parents = new HashMap<>();
            traverse(root, null);

            Queue<TreeNode> q = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            int distance = 0;
            q.offer(target);
            visited.add(target);

            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if (distance == k) {
                        res.add(cur.val);
                        continue;
                    }

                    if (cur.left != null && !visited.contains(cur.left)) {
                        q.offer(cur.left);
                        visited.add(cur.left);
                    }
                    if (cur.right != null && !visited.contains(cur.right)) {
                        q.offer(cur.right);
                        visited.add(cur.right);
                    }
                    //向上，左，右三个方向奔跑
                    TreeNode curParent = parents.get(cur.val);
                    if (curParent != null && !visited.contains(curParent)) {
                        q.offer(curParent);
                        visited.add(curParent);
                    }
                }
                distance += 1;
            }

            return res;
        }

        private void traverse(TreeNode root, TreeNode parent) {
            if (root == null) return;
            parents.put(root.val, parent);
            traverse(root.left, root);
            traverse(root.right, root);
        }
    }


    static class Solution {
        // 记录父节点：node.val -> parentNode
        // 题目说了树中所有节点值都是唯一的，所以可以用 node.val 代表 TreeNode
        HashMap<Integer, TreeNode> parent = new HashMap<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            // 遍历所有节点，记录每个节点的父节点
            traverse(root, null);

            // 开始从 target 节点施放 BFS 算法，找到距离为 k 的节点
            Queue<TreeNode> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            q.offer(target);
            visited.add(target.val);
            // 记录离 target 的距离
            int dist = 0;
            List<Integer> res = new LinkedList<>();

            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    if (dist == k) {
                        // 找到距离起点 target 距离为 k 的节点
                        res.add(cur.val);
                    }
                    // 向父节点、左右子节点扩散
                    TreeNode parentNode = parent.get(cur.val);
                    if (parentNode != null && !visited.contains(parentNode.val)) {
                        visited.add(parentNode.val);
                        q.offer(parentNode);
                    }
                    if (cur.left != null && !visited.contains(cur.left.val)) {
                        visited.add(cur.left.val);
                        q.offer(cur.left);
                    }
                    if (cur.right != null && !visited.contains(cur.right.val)) {
                        visited.add(cur.right.val);
                        q.offer(cur.right);
                    }
                }
                // 向外扩展一圈
                dist++;
            }

            return res;
        }

        private void traverse(TreeNode root, TreeNode parentNode) {
            if (root == null) {
                return;
            }
            parent.put(root.val, parentNode);
            // 二叉树递归框架
            traverse(root.left, root);
            traverse(root.right, root);
        }
    }
}