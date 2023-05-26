package com.lsj.leetcode_lib.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linshujie
 */
public class C797 {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        List<List<Integer>> lists = new Solution2().allPathsSourceTarget(graph);
        for (List<Integer> list : lists) {
            System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        }

    }

    static class Solution2 {

        private List<List<Integer>> res;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            LinkedList<Integer> path = new LinkedList<>();
            res = new LinkedList<>();
            traverse(graph, 0, path);
            return res;
        }

        private void traverse(int[][] graph, int value, LinkedList<Integer> path) {
            //前进
            path.addLast(value);
            System.out.println(value + " -> " + Arrays.toString(path.toArray()));
            int target = graph.length - 1;
            if (value == target) {
                res.add(new LinkedList<>(path));
                System.out.println("path = " + Arrays.toString(path.toArray()));
            }

            //遍历不同的方向
            for (int i : graph[value]) {
                traverse(graph, i, path);
            }

            //后退
            path.removeLast();
            System.out.println(value + " <- " + Arrays.toString(path.toArray()));
        }
    }


    static class Solution {
        // 记录所有路径
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            // 维护递归过程中经过的路径
            LinkedList<Integer> path = new LinkedList<>();
            traverse(graph, 0, path);
            return res;
        }

        /* 图的遍历框架 */
        void traverse(int[][] graph, int s, LinkedList<Integer> path) {
            // 添加节点 s 到路径
            path.addLast(s);
            System.out.println("path -> " + Arrays.toString(path.toArray()));

            int n = graph.length;
            if (s == n - 1) {
                // 到达终点
                res.add(new LinkedList<>(path));
                // 可以在这直接 return，但要 removeLast 正确维护 path
                // path.removeLast();
                // return;
                // 不 return 也可以，因为图中不包含环，不会出现无限递归
            }

            // 递归每个相邻节点
            for (int v : graph[s]) {
                traverse(graph, v, path);
            }

            // 从路径移出节点 s
            path.removeLast();
            System.out.println("path <- " + Arrays.toString(path.toArray()));
        }
    }
}