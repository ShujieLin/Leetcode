package com.lsj.leetcode_lib.tree;

/**
 * 中序遍历：
 * 左子树--根结点-右子树
 * 思路：
 * 在访问左子树和右子树的时候安装同样的方式遍历，知道遍历完整棵树。可以用递归模拟这过程
 *
 * 实现：
 * 定义inorder(root)为递归函数
 * 递归调用inorder(root.left)遍历root节点的左子树
 * 将root加入。
 * inorder(root.right)遍历root的右子树。
 *
 * @date: 2022/7/5
 * @author: linshujie
 */
public class Chapter94 {

}

