package com.lsj.leetcode_lib.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author linshujie
 */
public class LevelTraverse {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        levelTraverse(node);
    }

    // 输入一棵二叉树的根节点，层序遍历这棵二叉树
    static void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);//根结点入队列

        while (!q.isEmpty()) {//前面那一轮入队的队列不为空的话
            int sz = q.size();//当前队列结点的总数，即每行的总数
            // 从左到右遍历每一行的节点个数
            for (int i = 0; i < sz; i++) {//每行的所有结点
                TreeNode cur = q.poll();//每次进来循环
                // 将下一层节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }


    static void levelTraverse2(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//offer比add更好，当加入有问题的时候offer不会抛出异常，而add会

        //判断当前队列是否为空，空的话代表所有的结点已经遍历完毕
        while (!queue.isEmpty()) {
            //这里需要知道当前队列的数量，即这一层有多少个结点
            int size = queue.size();
            //遍历当前这一层的所有的结点，遍历到的每一个都进行出队列，为下一层的结点入队列做准备。
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();//出队列，并拿到当前出队列的结点

                //下一层左右的结点分别入队
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

    }
}