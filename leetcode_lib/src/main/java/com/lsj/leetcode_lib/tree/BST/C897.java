package com.lsj.leetcode_lib.tree.BST;

import com.lsj.leetcode_lib.tree.TreeNode;
import com.lsj.leetcode_lib.tree.Utils;

/**
 * @author linshujie
 */
public class C897 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1), null),
                        new TreeNode(4)),
                new TreeNode(6,
                        null,
                        new TreeNode(8,
                                new TreeNode(7), new TreeNode(9))
                ));

        TreeNode treeNode2 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1), new TreeNode(3))
                , new TreeNode(5));
//        Utils.preTraverse(treeNode);
        TreeNode node = new Solution().increasingBST(treeNode);
//        Utils.preTraverse(node);
    }

    static class Solution {
        public TreeNode increasingBST(TreeNode root) {
            return traverse(root);
        }

        /**
         * 中序遍历搜索树，可以获得一个升序列表
         *
         * @param root
         */
        private TreeNode traverse(TreeNode root) {
            if (root == null) return null;

            TreeNode left = traverse(root.left);
            //把左边断开
            root.left = null;

            TreeNode right = traverse(root.right);
           /* if (root.right != right) {
                System.out.println("root = " + root.val);
                System.out.println("right = " + right.val);
                System.out.println("root.right = " + root.right.val);
            }*/
            //操作过后，会把左子结点重新返回给父结点，这时候需要父结点重新把新的右子节点连接上，例如本例子中的6节点
            root.right = right;

//            System.out.println("root.right = " + root.right.val + " right.val = " + right.val);

            //判断root是否存在left，不存在的话，无需处理
            if (left == null) return root;

            //把root接到left的右边
            TreeNode p = left;
            while (p.right!=null){
                p = p.right;
            }
            p.right = root;

            return left;
        }
    }

    static class Solution2 {
        // 输入一棵 BST，返回一个有序「链表」
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }

//            System.out.println(" -> " + root.val);

            TreeNode left = increasingBST(root.left);
            System.out.println(" -- " + root.val);
            //断开
            root.left = null;

            TreeNode right = increasingBST(root.right);
            System.out.println(" <- " + root.val);
            root.right = right;

            // 左子树为空的话，就不用处理了
            if (left == null) {
                return root;
            }
            // 左子树非空，需要把根节点和右子树接到左子树末尾
            TreeNode p = left;
            while (p != null && p.right != null) {
                p = p.right;
            }
            p.right = root;

            return left;
        }
    }
}