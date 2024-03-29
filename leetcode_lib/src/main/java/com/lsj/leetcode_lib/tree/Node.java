package com.lsj.leetcode_lib.tree;

/**
 * @author linshujie
 */
// Definition for a Node.
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node left, Node right) {
        val = _val;
        this.left = left;
        this.right = right;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
