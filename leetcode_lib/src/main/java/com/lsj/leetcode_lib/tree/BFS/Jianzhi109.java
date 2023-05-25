package com.lsj.leetcode_lib.tree.BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author: linshujie
 */
public class Jianzhi109 {
    /**
     * ["8887","8889","8878","8898","8788","8988","7888","9888"]
     * "8888"
     */
    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String t = "0202";
        String[] deadends2 = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String t2 = "8888";
        int i = new Solution().openLock(deadends2, t2);
        System.out.println("i = " + i);
    }

    static class Solution {
        public int openLock(String[] deadends, String target) {
            return bfs(deadends, target);
        }

        private int bfs(String[] deadends, String target) {
            int count = 0;
            Queue<String> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));

            q.offer("0000");
            visited.add("0000");
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    String cur = q.poll();
                    if (deadendsSet.contains(cur)){
                        System.out.println("cur = " + cur);
                        continue;
                    }

                    if (cur.equals(target)) {
                        System.out.println("target = " + target);
                        return count;
                    }

                    //向两个不同方向奔跑
                    for (int j = 0; j < 4; j++) {
                        String plusOne = plus(cur, j);
                        if (!visited.contains(plusOne)) {
                            q.offer(plusOne);
                            visited.add(plusOne);
                        }

                        String reduceOne = reduce(cur, j);
                        if (!visited.contains(reduceOne)) {
                            q.offer(reduceOne);
                            visited.add(reduceOne);
                        }
                    }
                }
                count++;
            }

            return -1;
        }

        private String reduce(String cur, int i) {
            char[] chars = cur.toCharArray();
            if (chars[i] == '0') {
                chars[i] = '9';
            } else {
                chars[i] -= 1;
            }
            return new String(chars);
        }

        private String plus(String cur, int i) {
            char[] chars = cur.toCharArray();
            if (chars[i] == '9') {
                chars[i] = '0';
            } else {
                chars[i] += 1;
            }
            return new String(chars);
        }
    }
}