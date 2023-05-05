package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class C1080 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5,
                new TreeNode(4, //左子树
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(1)),
                        null),
                new TreeNode(8,//右子树
                        new TreeNode(17),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(3))));
        TreeNode node2 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(-99)),
                new TreeNode(3));

        TreeNode node3 = new TreeNode(5,
                new TreeNode(-6),
                new TreeNode(-6));

        TreeNode result = new Solution2().sufficientSubset(node3, 0);

        Utils.preTraverse(result);
    }

    static class Solution2 {
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            return traverse(root, limit);
        }

        /**
         * 删除所有不足节点
         *
         * @param root
         * @param limit
         * @return
         */
        private TreeNode traverse(TreeNode root, int limit) {
            if (root == null) return null;
            System.out.println("root = " + root.val + " limit = " + limit);
            //遍历到叶子节点，假如不满足limit条件，删除它，return null处理。
            if (root.left == null && root.right == null) {//叶节点
                //
                if (root.val < limit) {
                    return null;
                }
                return root;
            }

            TreeNode left = traverse(root.left, limit - root.val);
            TreeNode right = traverse(root.right, limit - root.val);

            //遍历到底，现在返程出去
            //判断是否回去的路上，是否有左右子节点都是null的，是的话为【不足节点】，需要删除
            //!!!注意这里有问题：原来的树底部不为null，直接使用root.left后续遍历这一步删除不了，会导致【不足节点】无法被删除，导致错误
            /*if (root.left == null && root.right == null) {
                return null;
            }*/

            //正确写法：需要拿到前序遍历时候放回的结点，因为前序遍历的时候判断过是否满足条件，不满足返回null
            if (left == null && right == null) return null;

            //出去的时候需要重新指向 子节点
            root.left = left;
            root.right = right;
            return root;
        }
    }


    static class Solution {
        // 定义：输入一个节点 root，和约束 limit，
        // 删除以 root 为根的二叉树中的「不足节点」，返回删除完成后的二叉树根节点
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            if (root == null) {
                return null;
            }
            System.out.println("pre = " + root.val);
            // 前序位置，接收父节点传递的 limit 约束决定叶子结点是否需要被删除
            if (root.left == null && root.right == null) {
                if (root.val < limit) {
                    // 对于叶子节点，如果低于 limit 说明需要被删除
                    return null;
                }
                return root;
            }
//            System.out.println("pre = " + root.val);
            // 先对左右子树进行删除，接收返回值
            TreeNode left = sufficientSubset(root.left, limit - root.val);
            TreeNode right = sufficientSubset(root.right, limit - root.val);
            System.out.println("after = " + root.val);
            // 后序位置，根据子树的删除情况决定自己是否需要被删除
            if (left == null && right == null) {
                // 如果左右子树不满足 limit - root.val 的约束，那么就存在经过 root
                // 节点的路径不满足约束，也就说明 root 节点是「不足节点」，需要被删掉
                return null;
            }
            root.left = left;
            root.right = right;
            return root;
        }
    }
}