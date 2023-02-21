package com.shujie.datastructure.tree;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: linshujie
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes = " + nodes);

        System.out.println("赫夫曼树");
        Node huffmanTree = creatHuffmanTree(nodes);
        System.out.println("前序遍历");

        huffmanTree.preOrder();

        getCodes(huffmanTree,"",sb);
        System.out.println("赫夫曼编码表 = " + huffmanCodes);
    }

    static Map<Byte,String> huffmanCodes = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

/*    private static Map<Byte,String> getCodes(Node root){
        if (root == null) return null;
        getCodes(root.left,"0",sb);
        getCodes(root.right,"1",sb);
        return huffmanCodes;
    }*/

    /**
     * 根据哈夫曼树得到赫夫曼编码，添加到集合中
     * @param node 传入的节点
     * @param code 路径：左子结点为0，右子节点为1
     * @param sb
     */
    private static void getCodes(Node node,String code,StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node != null){
            if (node.data == null){
                getCodes(node.left,"0",sb2);
                getCodes(node.right,"1",sb2);
            }else {
                huffmanCodes.put(node.data, sb2.toString());
            }
        }
    }

    private static void preOrder(Node root) {
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("tree is null");
        }
    }

    private static Node creatHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            //排序，从小到大
            Collections.sort(nodes);
            //取出最小的两个二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //创建一个新的二叉树，它的根节点没有data，只有权值
            Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<>();

        //遍历bytes，同一每个byte出现的次数
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b :
                bytes) {
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b,1);
            }else {
                counts.put(b,count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry: counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

}
    class Node implements Comparable<Node>{
        Node left;
        Node right;
        int weight;
        Byte data;

        public Node(Byte data,int weight) {
            this.weight = weight;
            this.data = data;
        }

        @Override
        public int compareTo(Node o) {
            //从小到大排序
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                   /* "left=" + left +
                    ", right=" + right +*/
                    ", weight=" + weight +
                    ", data=" + data +
                    '}';
        }

        public void preOrder() {
            System.out.println(this);
            if (this.left != null){
                this.left.preOrder();
            }

            if (this.right != null){
                this.right.preOrder();
            }
        }
    }