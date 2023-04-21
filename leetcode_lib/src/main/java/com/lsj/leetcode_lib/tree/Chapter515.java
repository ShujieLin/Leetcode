package com.lsj.leetcode_lib.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author linshujie
 */
public class Chapter515 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        List<Integer> list = new Solution().largestValues(node);
        System.out.println("list = " + Arrays.toString(list.toArray()));
    }

    static class Solution{
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> list = new LinkedList();
            if(root == null) return list;
            Queue<TreeNode> queue = new LinkedList();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                //每一层遍历完之后，重置一下最大值
                int maxValue = Integer.MIN_VALUE;

                //遍历该层的所有节点
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if(node != null){
                        maxValue = Math.max(maxValue, node.val);
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                //遍历完一层，添加最大值到结果
                list.add(maxValue);
            }
            return list;
        }
    }




//    class Solution {
//        public List<Integer> largestValues(TreeNode root) class Solution {
//            public List<Integer> largestValues(TreeNode root) {
//                List<Integer> list = new LinkedList();
//                Queue<TreeNode> queue = new LinkedList();
//                queue.offer(root);
//                while(!queue.isEmpty){
//                    int size = queue.size;
//                    //每一层遍历完之后，重置一下最大值
//                    int maxValue = Math.minValue();
//
//                    //遍历该层的所有节点
//                    for(int i = 0;i <size;i++){
//                        TreeNode node = queue.poll;
//                        maxValue = Math.maxValue(maxValue,node.val);
//
//                        if(node.left != null) {
//                            queue.offer(node.left);
//                        }
//
//                        if(node.right != null){
//                            queue.offer(node.right);
//                        }
//                    }
//                    //遍历完一层，添加最大值到结果
//                    list.add(maxValue);
//                }
//
//                return list;
//            }
//        }
//
//    }
}
