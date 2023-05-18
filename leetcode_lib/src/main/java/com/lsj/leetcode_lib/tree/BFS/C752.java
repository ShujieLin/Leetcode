package com.lsj.leetcode_lib.tree.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author linshujie
 */
public class C752 {
    public static void main(String[] args) {

//        int res = new Solution().openLock(new String[]{"8888"}, "0009");
        int res2 = new Solution().openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202");
        System.out.println("res = " + res2);
    }

    static class Solution {
        public int openLock(String[] deadends, String target) {

            return bfs(deadends, target);
        }

        private int bfs(String[] deadends, String target) {
            int step = 0;
            Queue<String> queue = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();
            HashSet<String> deadendsList = new HashSet<>(Arrays.asList(deadends));

            queue.offer("0000");
            visited.add("0000");

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    //假如找到deadends，跳过
                    if (deadendsList.contains(cur)) continue;

                    //判断是否找到target
                    if (target.equals(cur)) return step;
                    System.out.println("cur = " + cur);

                    //拨动拨轮
                    for (int j = 0; j < 4; j++) {
                        //判断是否访问过
                        String plusRes = plus(cur, j);
                        if (!visited.contains(plusRes)) {
                            queue.offer(plusRes);
                            visited.add(plusRes);
                        }

                        String reduceRes = reduce(cur, j);
                        if (!visited.contains(reduceRes)) {
                            queue.offer(reduceRes);
                            visited.add(reduceRes);
                        }
                    }
                }
                step++;
            }

            return -1;
        }

        private String reduce(String cur, int index) {
            char[] array = cur.toCharArray();
            if (array[index] == '0') {
                array[index] = '9';
            } else {
                array[index] -= 1;
            }
            return new String(array);
        }

        private String plus(String cur, int index) {
            char[] array = cur.toCharArray();

            if (array[index] == '9') {
                array[index] = '0';
            } else {
                array[index] += 1;
            }

            return new String(array);
        }
    }
}