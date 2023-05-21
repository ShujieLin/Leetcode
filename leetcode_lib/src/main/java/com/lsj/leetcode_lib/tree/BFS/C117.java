package com.lsj.leetcode_lib.tree.BFS;

import com.lsj.leetcode_lib.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: linshujie
 */
public class C117 {
    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5), null),
                new Node(3,
                        null,
                        new Node(7), null),
                null);
        Node connect = new Solution2().connect(node);

    }

    static class Solution2 {
        public Node connect(Node root) {
            return bfs(root);
        }

        private Node bfs(Node root) {
            if (root == null) return null;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()){
                int size = queue.size();

                //临时保持上一个节点
                Node pre = null;

                //遍历每一层
                for (int i = 0; i < size; i++) {
                    Node cur = queue.poll();
                    if (pre != null) {
                        pre.next = cur;
                    }
                    pre = cur;
                    System.out.println("pre = " + pre.val);

                    if (cur.left != null) queue.offer(cur.left);

                    if (cur.right!=null) queue.offer(cur.right);

                }
            }
            return root;
        }

    }


    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            // 二叉树层序遍历框架
            Queue<Node> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int sz = q.size();

                // 遍历一层
                Node pre = null;
                for (int i = 0; i < sz; i++) {
                    Node cur = q.poll();
                    // 链接当前层所有节点的 next 指针
                    if (pre != null) {
                        pre.next = cur;
                    }
                    pre = cur;
                    // 将下一层节点装入队列
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
            }
            return root;
        }
    }
}