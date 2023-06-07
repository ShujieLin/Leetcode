package com.lsj.leetcode_lib.DP;

/**
 * @author linshujie
 */
public class C509 {
    public static void main(String[] args) {

        /*int fib = new Solution().fib2(5);
        System.out.println("fib = " + fib);*/

        int fib = new MySolution2().fib(5);
        System.out.println("fib = " + fib);


    }

    static class MySolution {
        public int fib(int n) {
            System.out.println("->");
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;
            int res = fib(n - 1) + fib(n - 2);//存在重复计算
            System.out.println("<- res = " + res + " n = " + n);
            return res;
        }
    }

    static class MySolution2 {
        /**
         * 添加备忘录
         */
        public int fib(int n) {
            int[] memo = new int[n + 1];
            return dp(n, memo);
        }

        private int dp(int n, int[] memo) {
            System.out.println("->");
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;
            if (memo[n] != 0) return memo[n];//避免了重复计算已经计算过的结果
            //保存当前结果到备忘录中
            memo[n] = dp(n - 1, memo) + dp(n - 2, memo);
            System.out.println("<- memo[n] = " + memo[n] + " n = " + n);
            return memo[n];
        }
    }

    static class MySolution3 {
        /**
         * 转移方程式
         */
        public int fib(int n) {
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    static class Solution {
        int fib(int N) {
            System.out.println(" ----> N = " + N);
            if (N == 1 || N == 2) {
                System.out.println(" <---- 1");
                return 1;
            }
            int res = fib(N - 1) + fib(N - 2);
            System.out.println(" <---- res = " + res);
            return res;
        }

        /**
         * 带备忘录
         *
         * @param N
         * @return
         */
        int fib2(int N) {
            // 备忘录全初始化为 0
            int[] memo = new int[N + 1];
            // 进行带备忘录的递归
            return dp(memo, N);
        }

        // 带着备忘录进行递归
        int dp(int[] memo, int n) {
            System.out.println("->");
            // base case
            if (n == 0 || n == 1) return n;
            // 已经计算过，不用再计算了
            if (memo[n] != 0) return memo[n];
            memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
            System.out.println("<- memo[n] = " + memo[n] + " n = " + n);
            return memo[n];
        }

        /**
         * 转移方程式
         *
         * @param N
         * @return
         */
        int fib3(int N) {
            if (N == 0) return 0;
            int[] dp = new int[N + 1];
            // base case
            dp[0] = 0;
            dp[1] = 1;
            // 状态转移
            for (int i = 2; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[N];
        }

        int fib4(int n) {
            if (n == 0 || n == 1) {
                // base case
                return n;
            }
            // 分别代表 dp[i - 1] 和 dp[i - 2]
            int dp_i_1 = 1, dp_i_2 = 0;
            for (int i = 2; i <= n; i++) {
                // dp[i] = dp[i - 1] + dp[i - 2];
                int dp_i = dp_i_1 + dp_i_2;
                // 滚动更新
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i_1;
        }
    }
}