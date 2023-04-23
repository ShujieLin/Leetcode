package com.lsj.leetcode_lib.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author linshujie
 */
public class Chapter116 {
    public static void main(String[] args) {

    }

     static class Solution {
        public Node connect(Node root) {
            if(root == null) return null;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();

                for(int i = 0;i < size;i++){
                    //全部改层的所有结点都出队列
                    Node node = queue.poll();

                    if(node.left != null) queue.offer(node.left);

                    if(node.right != null) queue.offer(node.right);
                }
            }
        }
    }
}

