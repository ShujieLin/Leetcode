package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;
import com.lsj.leetcode_lib.tree.Utils;

/**
 * @author: linshujie
 */
public class JZ26 {
    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1), new TreeNode(2)),
                new TreeNode(5));
        TreeNode nodeB = new TreeNode(4,
                new TreeNode(1), null);

      /*  Utils.infixTraverse(node);
        Utils.preTraverse(node);
        Utils.postTraverse(node);*/

        boolean subStructure = new Solution4().isSubStructure(nodeA, nodeB);
        System.out.println("subStructure = " + subStructure);

        TreeNode nodeA2 = new TreeNode(1,
                new TreeNode(0,
                        new TreeNode(-4),
                        new TreeNode(-3)),
                new TreeNode(1));
        TreeNode nodeB2 = new TreeNode(1,
                new TreeNode(-4), null);
        boolean subStructure2 = new Solution4().isSubStructure(nodeA2, nodeB2);
        System.out.println("subStructure2 = " + subStructure2);
    }

    static class Solution4 {
        public boolean isSubStructure(TreeNode A, TreeNode B) {

            //判断子结构是否一致的时候，A和B都必须不能为空
            if (A == null || B == null) return false;
            //先判断是否为子结构
            //再递归判断A的左右子结构是否等于B
            return isSubNode(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean isSubNode(TreeNode a, TreeNode b) {
            //先判断b,因为是检查是否a包含b
            if (b == null) return true;
            if (a == null || a.val != b.val) return false;
            return isSubNode(a.left, b.left) && isSubNode(a.right, b.right);
        }
    }

    static class Solution3 {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            //递归
            //判断非叶子结点，在判断叶子结点
            if (A == null || B == null) return false;

            return isSubNode(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean isSubNode(TreeNode a, TreeNode b) {
            if (a != null) {
                System.out.println("a.val = " + a.val);
            } else {
                System.out.println("a = null");
            }
            if (b != null) {
                System.out.println("b.val = " + b.val);
            } else {
                System.out.println("b  =  null");
            }
            //判断是否相同
            //先判断b,b==null，a！=null可以成立，放过来不成立
            if (b == null) return true;

            //null也是每个树的子树
            if (a == null || a.val != b.val) return false;

            return isSubNode(a.left, b.left) && isSubNode(a.right, b.right);
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class Solution2 {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            //递归
            //在树 A 中找到与树 B 根节点相同的节点。
            if (A == null || B == null) return false;

            //从找到的节点开始判断以该节点为根的子树是否与树 B 相同。
            return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean isSub(TreeNode a, TreeNode b) {
            if (b == null) return true;
            if (a == null || a.val != b.val) return false;
            return isSub(a.left, b.left) && isSub(a.right, b.right);
        }
    }

    static class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }
            return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean isSubTree(TreeNode A, TreeNode B) {
            if (B == null) {
                return true; // 空树是任意树的子结构
            }
            if (A == null || A.val != B.val) {
                return false;
            }
            return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
        }
    }
}
