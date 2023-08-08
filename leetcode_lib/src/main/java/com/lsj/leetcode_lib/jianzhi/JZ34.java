package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: linshujie
 */
public class JZ34 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        List<List<Integer>> lists = new Solution().pathSum(treeNode, 4);
        System.out.println("lists = " + Arrays.toString(lists.toArray()));
    }

    /**
     * 使用深度优先搜索（DFS）来遍历二叉树的所有路径。从根节点开始递归地访问每个节点，并在递归过程中记录路径的节点值和。
     * <p>
     * 在每次访问一个节点时，将当前节点的值加入路径的列表中，并将目标和减去当前节点的值。然后，判断当前节点是否为叶子节点，如果是叶子节点并且目标和为0，则说明找到了一条路径，将该路径添加到结果列表中。
     * <p>
     * 继续递归访问当前节点的左子树和右子树，注意在递归结束后要将当前节点从路径列表中移除，以便回溯到父节点继续搜索其他路径。
     * <p>
     * 最终，当遍历完所有可能的路径后，返回结果列表即可。
     */
    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<Integer> curPath = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            traverse(root, target, curPath, res);
            return res;
        }

        private void traverse(TreeNode root, int target, List<Integer> curPath, List<List<Integer>> res) {
            if (root == null) return;

            //设置变量，记录target
            int curTarget = target - root.val;
            curPath.add(root.val);
            System.out.println("curPath = " + Arrays.toString(curPath.toArray()) + " curTarget = " + curTarget);

            //判断，当前结点target为0，并且左右节点为null，说明是叶子结点
            if (curTarget == 0 && root.left == null && root.right == null) {
//                res.add(curPath);
                res.add(new ArrayList<>(curPath));
            }

            //递归到叶子结点
            traverse(root.left, curTarget, curPath, res);
            traverse(root.right, curTarget, curPath, res);

            curPath.remove(curPath.size() - 1);
        }
    }
}
