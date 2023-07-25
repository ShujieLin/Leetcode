package com.lsj.leetcode_lib.jianzhi;

import java.util.TreeSet;

/**
 * @author: linshujie
 */
public class JZ057 {
    public static void main(String[] args) {
       /* int[] nums = new int[]{1,2,3,1};
        int k = 3,t = 0;*/
      /*  int[] nums = new int[]{1,0,1,1};
        int k = 1,t = 2;*/

        /*int[] nums = new int[] { 1, 5, 9, 1, 5, 9 };*/
   /*     int[] nums = new int[] {2147483640,2147483641};
        int k = 1, t = 100;*/

        /*[-2147483640,-2147483641]*/
        int[] nums = new int[] {-2147483640,-2147483641};
        int k = 1, t = 100;


        boolean b = new Solution3().containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println("b = " + b);
       /* long l = 2147483640 + 100;
        System.out.println("test  = " + l);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE = " + (long)(Integer.MAX_VALUE + 100));*/
    }

    static class Solution3 {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int left = 0, right = 0;
            TreeSet<Long> window = new TreeSet<>();

            while (right < nums.length) {

                //控制窗口
                while (right - left > k) {
                    window.remove((long)nums[left]);
                    left++;
                }

                //t判断
                Long ceiling = window.ceiling(/*必须强转其中一个，否则导致越界变为负值*/(long)nums[right] - t);
                if (ceiling != null && ceiling <= (long)nums[right]/*必须强转其中一个，否则导致越界变为负值*/ + t) {
                    return true;
                }

                window.add((long) nums[right]);
                right++;
            }
            return false;
        }
    }

    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            //滑动窗口
            int left = 0, right = 0;
            TreeSet<Integer> window = new TreeSet<>();

            while (right < nums.length) {
                //k控制滑动窗口
                while (right - left > k) {
                    //缩小窗口
                    window.remove(nums[left]);
                    left++;
                }

                System.out.println("window = " + window);
                //t控制结果，存在，就返回true
                //我们需要在窗口中找到一个元素，它的值大于等于(nums[right] - t)并且小于等于(nums[right] + t)的范围。如果存在这样的元素，那么说明存在一个索引i和j，满足abs(nums[i] - nums[j]) <= t。
                Integer ceiling = window.ceiling(nums[right] - t);//获取大于等于nums[right] - t的最小元素
                System.out.println(
                        " nums[right] - t = " + (nums[right] - t) + " ceiling = " + ceiling);
                if (ceiling != null && ceiling <= nums[right] + t) {
                    return true;
                }

                window.add(nums[right]);
                right++;
            }
            return false;
        }
    }

    class Solution2 {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Long> window = new TreeSet<>();

            for (int i = 0; i < nums.length; i++) {
                if (i > k) {
                    window.remove((long) nums[i - k - 1]);
                }

                Long ceiling = window.ceiling((long) nums[i] - t);
                if (ceiling != null && ceiling - nums[i] <= t) {
                    return true;
                }

                window.add((long) nums[i]);
            }

            return false;
        }
    }
}