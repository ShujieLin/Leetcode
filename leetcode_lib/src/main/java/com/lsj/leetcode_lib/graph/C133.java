package com.lsj.leetcode_lib.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: linshujie
 */
public class C133 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        new Solution().cloneGraph(node1);
    }

    static class Solution2 {
        private Set<Node> visited;

        public Node cloneGraph(Node node) {
            visited = new HashSet<>();
            traverse(node);

            return null;
        }

        private void traverse(Node node) {
            if (node == null) return;
            if (visited.contains(node)) return;
            visited.add(node);

            for (Node n : node.neighbors) {
                System.out.println("n = " + n.val);
                traverse(n);
            }
        }
    }

    static class Solution {
        // 记录 DFS 遍历过的节点，防止走回头路
        HashSet<Node> visited = new HashSet<>();
        // 记录原节点到克隆节点的映射
        HashMap<Node, Node> originToClone = new HashMap<>();

        public Node cloneGraph(Node node) {
            // DFS 遍历图，顺便构建克隆图
            traverse(node);
            // 从 map 里找到克隆图的对应节点
            return originToClone.get(node);
        }

        // DFS 图遍历框架
        void traverse(Node node) {
            if (node == null) {
                return;
            }
            if (visited.contains(node)) {
                return;
            }
            // 前序位置，标记为已访问
            visited.add(node);
            // 前序位置，克隆节点
            if (!originToClone.containsKey(node)) {
                originToClone.put(node, new Node(node.val));
            }
            Node cloneNode = originToClone.get(node);

            // 递归遍历邻居节点，并构建克隆图
            for (Node neighbor : node.neighbors) {
                System.out.println("neighbor.val = " + neighbor.val);
                traverse(neighbor);
                // 递归之后，邻居节点一定存在 originToClone 中
                Node cloneNeighbor = originToClone.get(neighbor);
                cloneNode.neighbors.add(cloneNeighbor);
            }
        }
    }

}