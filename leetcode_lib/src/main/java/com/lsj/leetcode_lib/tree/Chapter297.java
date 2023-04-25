package com.lsj.leetcode_lib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linshujie
 */
public class Chapter297 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String serialize = new Codec().serialize(treeNode);
        System.out.println("serialize = " + serialize);
        new Codec().deserialize(serialize);
    }

    static class Codec {
        private static final String NULL = "#";
        private static final String SEP = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            sb.append(root.val).append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            //使用容器装起来，后面需要遍历的时候进行remove，使用linkdedlist
            List<String> list = new LinkedList<>();
            for (String s :
                    data.split(SEP)) {
                list.add(s);
            }
            return deserialize(list);
        }

        private TreeNode deserialize(List list) {
            if (list.isEmpty()) {
                return null;
            }
            String s = (String) list.remove(0);
            if (s.equals(NULL)) return null;

            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = deserialize(list);
            root.right = deserialize(list);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}