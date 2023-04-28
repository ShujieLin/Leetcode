package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class C1008 {
    public static void main(String[] args) {
      /*  TreeNode node = new TreeNode(8,
                new TreeNode(5, new TreeNode(1), new TreeNode(7)),
                new TreeNode(10, null, new TreeNode(12)));*/
//        Utils.preTraverse(node);
        int[] nums = new int[]{8, 5, 1, 7, 10, 12};
        TreeNode treeNode = new Solution().bstFromPreorder(nums);
        Utils.preTraverse(treeNode);
    }

    static class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            return build(preorder, 0, preorder.length - 1);
        }

        private TreeNode build(int[] preorder, int low, int high) {
            if (low > high) return null;

            //root
            TreeNode root = new TreeNode(preorder[low]);

            //指针，获取右子树的第一个元素。
            int p = low + 1;

            while (p <= high && preorder[p] < preorder[low]) {
                p++;
            }

            //左子树
            root.left = build(preorder, low + 1, p - 1);
            //右子树
            root.right = build(preorder, p, high);
            return root;
        }
    }

    static class Solution2 {
        public TreeNode bstFromPreorder(int[] preorder) {
            return build(preorder, 0, preorder.length - 1);
        }

        // 定义：将 preorder[start..end] 区间内的元素生成 BST，并返回根节点
        private TreeNode build(int[] preorder, int start, int end) {
            if (start > end) {
                return null;
            }
            // 根据前序遍历的特点，根节点在第一位，后面接着左子树和右子树
            int rootVal = preorder[start];
            TreeNode root = new TreeNode(rootVal);

            // 根据 BST 的特点，左子树都比根节点的值小，右子树都比根节点的值大
            // p 就是左右子树的分界点
            int p = start + 1;
            while (p <= end && preorder[p] < rootVal) {
                p++;
            }
            // [start+1, p-1] 区间内是左子树元素
            root.left = build(preorder, start + 1, p - 1);
            // [p, end] 区间内是右子树元素
            root.right = build(preorder, p, end);

            return root;
        }
    }
}