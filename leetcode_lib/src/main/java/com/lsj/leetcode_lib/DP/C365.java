package com.lsj.leetcode_lib.DP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: linshujie
 */
public class C365 {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {

            return false;
        }
    }

    static class Solution2 {
        public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
            // BFS 算法的队列
            Queue<int[]> q = new LinkedList<>();
            // 用来记录已经遍历过的状态，把元组转化成数字方便存储哈希集合
            // 转化方式是 (x, y) -> (x * (jug2Capacity + 1) + y)，和二维数组坐标转一维坐标是一样的原理
            // 因为水桶 2 的取值是 [0, jug2Capacity]，所以需要额外加一，请类比二维数组坐标转一维坐标
            // 且考虑到题目输入的数据规模较大，相乘可能导致 int 溢出，所以使用 long 类型
            HashSet<Long> visited = new HashSet<>();
            // 添加初始状态，两个桶都没有水
            q.offer(new int[]{0, 0});
            visited.add(0L);

            while (!q.isEmpty()) {
                int[] curState = q.poll();
                if (curState[0] == targetCapacity || curState[1] == targetCapacity
                        || curState[0] + curState[1] == targetCapacity) {
                    // 如果任意一个桶的水量等于目标水量，就返回 true
                    return true;
                }
                // 计算出所有可能的下一个状态
                List<int[]> nextStates = new LinkedList<>();
                // 把 1 桶灌满
                nextStates.add(new int[]{jug1Capacity, curState[1]});
                // 把 2 桶灌满
                nextStates.add(new int[]{curState[0], jug2Capacity});
                // 把 1 桶倒空
                nextStates.add(new int[]{0, curState[1]});
                // 把 2 桶倒空
                nextStates.add(new int[]{curState[0], 0});
                // 把 1 桶的水灌进 2 桶，直到 1 桶空了或者 2 桶满了
                nextStates.add(new int[]{
                        curState[0] - Math.min(curState[0], jug2Capacity - curState[1]),
                        curState[1] + Math.min(curState[0], jug2Capacity - curState[1])
                });
                // 把 2 桶的水灌进 1 桶，直到 2 桶空了或者 1 桶满了
                nextStates.add(new int[]{
                        curState[0] + Math.min(curState[1], jug1Capacity - curState[0]),
                        curState[1] - Math.min(curState[1], jug1Capacity - curState[0])
                });

                // 把所有可能的下一个状态都放进队列里
                for (int[] nextState : nextStates) {
                    long hash = (long)nextState[0] * (jug2Capacity + 1) + nextState[1];
                    if (visited.contains(hash)) {
                        // 如果这个状态之前遍历过，就跳过，避免队列永远不空陷入死循环
                        continue;
                    }
                    q.offer(nextState);
                    visited.add(hash);
                }
            }
            return false;
        }

    }
}
