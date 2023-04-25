package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
public class Chapter106 {
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode treeNode = new Solution().buildTree(inorder, postorder);
        
    }

    static class Solution {
        /**
         * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
         * 输出：[3,9,20,null,null,15,7]
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * @param inorder
         * @param postorder
         * @return
         */
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
        }

        private TreeNode build(int[] inorder, int startIn, int endIn, int[] postorder, int startPost, int endPost) {
            if (startIn > endIn) return null;
            //后续数组的最后一个结点就是root
            int rootValue = postorder[endPost];
            int index = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootValue) {
                    index = i;
                }
            }

            //找到左子树的结点数量
            int leftSize = index - startIn;

            TreeNode root = new TreeNode(rootValue);
            System.out.println("rootValue = " + rootValue);
            root.left = build(inorder, startIn, index - 1, postorder, startPost, startPost + leftSize - 1);
            root.right = build(inorder, index + 1, endIn, postorder, startPost + leftSize /*index = 长度 - 1*/, endPost - 1);
            return root;
        }
    }
}
