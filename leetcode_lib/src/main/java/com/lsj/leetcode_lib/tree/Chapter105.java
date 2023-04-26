package com.lsj.leetcode_lib.tree;

/**
 * @author: linshujie
 */
public class Chapter105 {
    public static void main(String[] args) {


    }


    /**
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     * <p>
     * 输入: preorder = [-1], inorder = [-1]
     * 输出: [-1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            //也可以使用中序的下标判断，选其一即可
            if (preStart > preEnd) return null;
            //前序遍历的第一个元素是root
            int rootValue = preorder[preStart];
            //找到中序遍历的root的下标
            int index = -1;
            for (int i = inStart; i < inorder.length; i++) {
                if (inorder[i] == rootValue) {
                    index = i;
                }
            }

            //左子树数量
            int leftSize = index - inStart;
            //新建结点
            TreeNode root = new TreeNode(rootValue);

            //前序遍历数组的left、right节点数量和中序遍历的left、right结点数量是一样的
            root.left = build(preorder, preStart + 1, preStart + leftSize/*长度值=下标值+1*/,
                    inorder, inStart, index - 1);
            root.right = build(preorder, preStart + leftSize + 1, preEnd,
                    inorder, index + 1, inEnd);
            return root;
        }
    }
}
