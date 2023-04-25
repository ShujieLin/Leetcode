package com.lsj.leetcode_lib.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linshujie
 */
public class Chapter652 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
        new Solution().findDuplicateSubtrees(treeNode);

    }

    static class Solution {
        List<TreeNode> res = new LinkedList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            serialize(root);
            return res;
        }

        private String serialize(TreeNode root) {
            if (root == null) return "#";

            String left = serialize(root.left);
            String right = serialize(root.right);
            String dyplicateTree = left + "," + right + "," + root.val;

            //使用hashmap来记录重复的次数
            //获取每个重复树的
            int count = hashMap.getOrDefault(dyplicateTree, 0);
            //添加结果集
            if (count == 0){
                res.add(root);
            }

            hashMap.put(dyplicateTree,++count);
            return dyplicateTree;
        }
    }
}
