package com.lsj.leetcode_lib.jianzhi;

/**
 * File description
 *
 * @author linshujie
 * @date 6/29/2023
 */
public class JZ49 {
    public static void main(String[] args) {
        int i = new Solution().nthUglyNumber(1);
        System.out.println("i = " + i);
    }

    static class Solution {
        public int nthUglyNumber(int n) {
            //丑数2 3 5
            int u2 = 1, u3 = 1, u5 = 1;
            int p2 = 1, p3 = 1, p5 = 1;//u2,u3,u5指针

            //丑数结果集合
            int[] ugly = new int[n + 1];
            int p = 0;//ugly的指针

            while (p < n) {
                int min = Math.min(u2, Math.min(u3, u5));
                p++;
                ugly[p] = min;
                System.out.println(" p = " + p + " " + "ugly = " + ugly[p]);
                if (min == u2) {
                    //如果一个数 x 是丑数，那么 x * 2, x * 3, x * 5 都一定是丑数。
                    u2 = 2 * ugly[p2];
                    p2++;
                }
                if (min == u3) {
                    u3 = 3 * ugly[p3];
                    p3++;
                }
                if (min == u5) {
                    u5 = 5 * ugly[p5];
                    p5++;
                }
            }
            return ugly[n];
        }
    }

    class Solution2 {
        public int nthUglyNumber(int n) {
            // 可以理解为三个指向有序链表头结点的指针
            int p2 = 1, p3 = 1, p5 = 1;
            // 可以理解为三个有序链表的头节点的值
            int product2 = 1, product3 = 1, product5 = 1;
            // 可以理解为最终合并的有序链表（结果链表）
            int[] ugly = new int[n + 1];
            // 可以理解为结果链表上的指针
            int p = 1;

            // 开始合并三个有序链表
            while (p <= n) {
                // 取三个链表的最小结点
                int min = Math.min(Math.min(product2, product3), product5);
                // 接到结果链表上
                ugly[p] = min;
                p++;
                // 前进对应有序链表上的指针
                if (min == product2) {
                    product2 = 2 * ugly[p2];
                    p2++;
                }
                if (min == product3) {
                    product3 = 3 * ugly[p3];
                    p3++;
                }
                if (min == product5) {
                    product5 = 5 * ugly[p5];
                    p5++;
                }
            }
            // 返回第 n 个丑数
            return ugly[n];
        }
    }
    // 详细解析参见：
    // https://labuladong.github.io/article/?qno=剑指 Offer 49
}
