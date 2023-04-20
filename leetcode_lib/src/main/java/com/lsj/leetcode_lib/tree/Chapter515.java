package com.lsj.leetcode_lib.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author linshujie
 */
public class Chapter515 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2,null,new TreeNode(9)));

    }

    class Solution {
        public List<Integer> largestValues(TreeNode root) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
//            while ()
            return null;
        }
    }
}
