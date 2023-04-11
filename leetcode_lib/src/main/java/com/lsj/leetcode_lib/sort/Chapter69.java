package com.lsj.leetcode_lib.sort;

/**
 * @author: linshujie
 */
public class Chapter69 {

    public static void main(String[] args) {
//        System.out.println(1/2 + "");

        System.out.println(new Solution3().mySqrt(2147395599) + "");
    }

    static class Solution {
        public int mySqrt(int x) {
            int left = 0, right = x, mid, result = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (mid * mid <= x) {
                    left = mid + 1;
                    result = mid;//最后一次分割，就是最接近平方根的值
                } else if (mid * mid > x) {
                    right = mid - 1;
                }
            }
            return result;
        }
    }

    static class Solution2 {
        public int mySqrt(int x) {
            int left = 0, right = x, mid, result = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if ((long) mid * mid <= x) {
                    left = mid + 1;
                    result = mid;//最后一次分割，就是最接近平方根的值
                } else if (mid * mid > x) {
                    right = mid - 1;
                }
            }
            return result;
        }
    }

    static class Solution3 {
        public int mySqrt(int x) {
            int left = 0, right = x, mid, result = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if ((long) mid * mid <= x) {
                    left = mid + 1;
                    result = mid;//最后一次分割，就是最接近平方根的值
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }
    }

    /*class Solution {
        public int mySqrt(int x) {
            int l = 0, r = x, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((long) mid * mid <= x) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return ans;
        }
    }

    作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}


