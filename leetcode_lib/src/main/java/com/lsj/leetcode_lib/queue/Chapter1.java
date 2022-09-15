package com.lsj.leetcode_lib.queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date: 2022/4/24
 * @author: linshujie
 */
public class Chapter1 {
    public static void main(String[] args) {

    }

    public int openLock(String[] dedends,String target){

        if ("0000".equals(target)){
            return 0;
        }

        // TODO: 2022/4/24 能用hashmap吗
        //
        HashSet<String> dead = new HashSet<>();
        for (String deadend :
                dedends) {
            dead.add(deadend);
        }
        if (dead.contains("0000"))
            return -1;

        //我们在一开始将(0000,0) 加入队列，并使用该队列进行广度优先搜索。
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        //存放已经搜索过的路径
        HashSet<String> seen = new HashSet<>();

        while (!queue.isEmpty()){
            ++step;
            int size = queue.size();
            //吧遍历
            for (int i = 0; i < size; i++) {
                //出队列
                String status = queue.poll();
                //进行广度优先搜索
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)){
                        if (nextStatus.equals( target))
                            return step;

                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    /**
     * {0,0,0,0}
     * @param status  队列头的字符串
     * @return
     */
    private List<String> get(String status) {
        //存放广度优先搜索的字符串集合
        ArrayList<String> ret = new ArrayList<>();
        //字符串的每个字符集合
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = array[i];

            array[i] = numPrev(num); //array[0] = 9
            ret.add(new String(array));//9
            array[i] = numSucc(num);//array[0] = 0
            ret.add(new String(array));//9,0,
            array[i] = num;//array[0] = 0
        }
        return ret;
    }

    private char numSucc(char num) {
        return num == '9' ? '0' : (char) (num + 1);
    }

    private char numPrev(char num) {
        return num == '0' ? '9' : (char) (num - 1);
    }
}
