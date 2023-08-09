package com.lsj.leetcode_lib.jianzhi;

import com.lsj.leetcode_lib.tree.Node;
import com.lsj.leetcode_lib.tree.TreeNode;

/**
 * @author linshujie
 */
public class JZ36 {
    public static void main(String[] args) {
        Node node = new Node(4,
                new Node(2,
                        new Node(1),
                        new Node(3)),
                new Node(5));
        Node head = new Solution().treeToDoublyList(node);

        Node cur = head;
        Node tail = head.left;

        while (cur != tail) {
            System.out.println("cur = " + cur.val);
            cur = cur.right;
        }
        System.out.println("cur = " + cur.val);

        //此时，cur==tail
        while (cur != head) {
            System.out.println("cur = " + cur.val);
            cur = cur.left;
        }
        System.out.println("cur = " + cur.val);
    }

    /**
     * 通过中序遍历二叉搜索树，并在遍历的过程中调整节点的指针来实现
     *
     * 创建一个全局变量 prev 来保存上一个遍历的节点，以及一个 head 变量来保存链表的头节点。
     *
     * 创建一个递归函数 inorder，接受一个当前遍历的节点 cur 作为参数。
     *
     * 在递归函数中，首先判断 cur 是否为空，如果为空，直接返回。
     *
     * 递归地对 cur 的左子树进行中序遍历：inorder(cur.left)。
     *
     * 在中序遍历的过程中，将 cur 与 prev 连接起来：
     *
     * 如果 prev 不为空，将 prev 的右指针指向 cur，同时 cur 的左指针指向 prev。
     * 如果 prev 为空，说明 cur 是中序遍历的第一个节点，此时需要将 head 指向 cur。
     * 更新 prev 为 cur，然后递归遍历 cur 的右子树：inorder(cur.right)。
     *
     * 最后，完成中序遍历后，将头尾连接成循环链表：将 head 的左指针指向尾节点，尾节点的右指针指向 head。
     */
    static class Solution {
        private Node pre;
        private Node head;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            inorder(root);

            //头尾相接
            pre.right = head;
            head.left = pre;

            return head;
        }

        private void inorder(Node cur) {
            if (cur == null) return;

            inorder(cur.left);

            if (pre != null) {
                pre.right = cur;
                cur.left = pre;
            } else {//如果 prev 为空，说明 cur 是中序遍历的第一个节点，此时需要将 head 指向 cur
                head = cur;
            }

            //更新 prev 为 cur，然后递归遍历 cur 的右子树：inorder(cur.right)。
            pre = cur;
            inorder(cur.right);
        }
    }
}
