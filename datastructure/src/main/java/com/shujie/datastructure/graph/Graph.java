package com.shujie.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date: 2022/11/19
 * @author: linshujie
 */
public class Graph {
    private ArrayList<String> vertextList;//存储顶点集合
    private int[][] edges;//存储图对应的邻结矩阵
    private int numOfEdges;//边的数目
    private boolean[] isVisited ;

    public static void main(String[] args) {
        int n = 5;
        String vertexs[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String vertex :
                vertexs) {
            graph.insertVertex(vertex);
        }

        //添加边
        graph.insetEdge(0,1,1);
        graph.insetEdge(0,2,1);
        graph.insetEdge(1,2,1);
        graph.insetEdge(1,3,1);
        graph.insetEdge(1,4,1);

        graph.showGraph();
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertextList = new ArrayList<String>();
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    public int getFirstNeighbor(int index){
        for (int j = 0; j < vertextList.size(); j++) {
            if (edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

 /*   public int getNextNeighbor(int v1,int v2){
        for (int j = v2 + 1 ;j < vertextList.size(); j++) {
            if (edges[v1][j] > 0){

            }
        }
    }*/

    /**
     * 返回节点个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertextList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回结点下标对应的数据
     *
     * @param i 下标
     * @return
     */
    public String getValueByIndex(int i) {
        return vertextList.get(i);
    }

    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    /**
     * 插入结点
     * @param vertex
     */
    public void insertVertex(String vertex){
        vertextList.add(vertex);
    }

    /**
     * 插入结点
     *
     * @param vertex
     */
    public void insetVertex(String vertex) {
        vertextList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1 example "A"-"B" "A"->0 "B"->1
     * @param v2
     * @param weight
     */
    public void insetEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public void showGraph(){
        for (int[] link :
                edges) {
            System.out.println(Arrays.toString(link));
        }
    }


}
