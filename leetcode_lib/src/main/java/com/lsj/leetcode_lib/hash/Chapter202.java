package com.lsj.leetcode_lib.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @date: 2022/5/13
 * @author: linshujie
 */
public class Chapter202 {
    public static void main(String[] args) {

//        new Solution().isHappy(7);
        System.out.println(10 / 7);
    }

    static class Solution {
        private int getNext(int n) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                System.out.println("d = " + d);
                n = n / 10;
                System.out.println("n = " + n);
                totalSum += d * d;
                System.out.println("totalSum = " + totalSum);
            }
            return totalSum;
        }

        public boolean isHappy(int n) {
            Set<Integer> seen = new HashSet<>();
            while (n != 1 && !seen.contains(n)) {
                seen.add(n);
                n = getNext(n);
            }
            return n == 1;
        }
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
