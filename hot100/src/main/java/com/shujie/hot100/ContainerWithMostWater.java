package com.shujie.hot100;

/**
 * @author linshujie
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = new Solution2().maxArea(height);
        System.out.println("maxArea = " + maxArea);
    }

    static class Solution2 {
        public int maxArea(int[] height) {
            int left = 0,right = height.length - 1;
            int res = 0;

            while (left< right){
                int area = (right - left) * Math.min(height[left],height[right]);
                res = Math.max(res,area);

                if (height[left] < height[right]){//最大面积取决于短板，移动短板
                    left ++;
                }else {
                    right --;
                }
            }
            return res;
        }
    }

    public class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);//面积，短木板*左右距离
                ans = Math.max(ans, area);
                if (height[l] <= height[r]) {//面积，木桶效应，木桶装水多少取决于最短的木板。为了找到面积最大，应该移动短木板。
                    ++l;
                } else {
                    --r;
                }
            }
            return ans;
        }
    }

    /*作者：力扣官方题解
    链接：https://leetcode.cn/problems/container-with-most-water/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
