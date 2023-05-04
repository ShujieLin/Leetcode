package com.lsj.leetcode_lib.tree.BST;

import com.lsj.leetcode_lib.tree.TreeNode;
import com.lsj.leetcode_lib.tree.Utils;

import java.util.LinkedList;

/**
 * @author linshujie
 */
public class C108 {

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
//        TreeNode node = new Solution().sortedArrayToBST(nums);
//        Utils.preTraverse(node);

        TreeNode node2 = new Solution2().sortedArrayToBST(nums);
        Utils.preTraverse(node2);
    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return traverse(nums, 0, nums.length - 1);
        }

        /**
         * 分解，数组的中间是跟
         * 先构造根，再构造左右子节点
         */
        private TreeNode traverse(int[] nums, int low, int high) {
            if (low > high) return null;
            int mid = low + (high - low) / 2;
            TreeNode root = new TreeNode(nums[mid]);

            root.left = traverse(nums, low, mid - 1);
            root.right = traverse(nums, mid + 1, high);
            return root;
        }
    }

    static class Solution2 {
        public TreeNode sortedArrayToBST(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        // 将闭区间 [left, right] 中的元素转化成 BST，返回根节点
        TreeNode build(int[] nums, int left, int right) {
            if (left > right) {
                // 区间为空
                return null;
            }
            // 构造根节点
            // BST 节点左小右大，中间的元素就是根节点
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            // 递归构建左子树
            root.left = build(nums, left, mid - 1);
            // 递归构造右子树
            root.right = build(nums, mid + 1, right);

            return root;
        }
    }
}