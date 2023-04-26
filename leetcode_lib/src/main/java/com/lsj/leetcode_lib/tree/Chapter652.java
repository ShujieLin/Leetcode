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
        new Solution2().findDuplicateSubtrees(treeNode);
        /*Utils.postTraverse(treeNode);*/
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
            String myself = left + "," + right + "," + root.val;
            System.out.println("dyplicateTree = " + myself);

            //使用hashmap来记录重复的次数
            //获取每个重复树的
            int count = hashMap.getOrDefault(myself, 0);

            //错误：count == 0，出现第一次，不算重复
            //假如重复，则添加结果集
           /* if (count == 0){
                res.add(root);
            }*/

            if (count == 1) res.add(root);

            hashMap.put(myself,++count);
            return myself;
        }
    }


    static class Solution2 {
        // 记录所有子树以及出现的次数
        HashMap<String, Integer> subTrees = new HashMap<>();
        // 记录重复的子树根节点
        LinkedList<TreeNode> res = new LinkedList<>();

        /* 主函数 */
        List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            serialize(root);
            return res;
        }

        /* 辅助函数 */
        String serialize(TreeNode root) {
            if (root == null) {
                return "#";
            }

            // 先算左右子树的序列化结果
            String left = serialize(root.left);
            String right = serialize(root.right);

            String myself = left + "," + right+ "," + root.val;

            System.out.println("myself = " + myself);
            int freq = subTrees.getOrDefault(myself, 0);
            // 多次重复也只会被加入结果集一次
            if (freq == 1) {
                res.add(root);
            }
            // 给子树对应的出现次数加一
            subTrees.put(myself, freq + 1);
            return myself;
        }
    }
}
