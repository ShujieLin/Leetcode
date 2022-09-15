package com.lsj.leetcode_lib.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @date: 2022/6/16
 * @author: linshujie
 */
public class Chapter144_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        /**
         * 错误答案
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return null;

            //创建容器
            List<Integer> list = new ArrayList<>();
            //创栈
            Deque<TreeNode> stack = new LinkedList();

            TreeNode node = root;
            //循环遍历,只有同时满足node为空和栈为空退出循环
            while (node != null || stack != null){
                while (node != null){
                    //把值添加到集合
                    list.add(node.val);
                    //入栈
                    stack.push(node);
                    //遍历所有节点的左节点，直到左节点为空
                    node = node.left;
                }

                //出栈
                node = stack.pop();
                node = node.right;
            }
            return list;
        }

        public List<Integer> preorderTraversal2(TreeNode root) {
            //创建容器
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;

            //创栈
            Deque<TreeNode> stack = new LinkedList();

            TreeNode node = root;
            //循环遍历,只有同时满足node为空和栈为空退出循环
            while (node != null || !stack.isEmpty()){
                while (node != null){
                    //把值添加到集合
                    list.add(node.val);
                    //入栈
                    stack.push(node);
                    //遍历所有节点的左节点，直到左节点为空
                    node = node.left;
                }

                //出栈
                node = stack.pop();
                node = node.right;
            }
            return list;
        }
    }
}