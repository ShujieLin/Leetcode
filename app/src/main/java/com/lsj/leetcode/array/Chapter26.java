package com.lsj.leetcode.array;

/**
 * @Description:
 * @Author: linshujie
 * @Date: 2022/1/25
 */
public class Chapter26 {
    public static void main(String[] args) {

//        int i = 1;
//        System.out.println(i = i++);
//        System.out.println(i = i++);
//        System.out.println(i = i++);
//        System.out.println(i = ++i);
//        System.out.println(i = ++i);
//        System.out.println(i = ++i);

        int[] nums = {1,2,3,3,4,5,6,6,6,6};
//        int sum = 0;
//        while (sum < 10){
//            ++sum;
//            System.out.println(sum);
//        }
    }


    private static int solution2(int[] nums){
        if (nums.length == 0)
            return 0;

        int fast = 1;
        int slow = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[fast] != nums[fast - 1]){
                nums[slow] = nums[fast];
                ++slow;
            }
            fast++;
        }
        return slow;
    }

    private static int solution(int[] nums){
        int n = nums.length;
        if (n == 0){
            return 0;
        }

        int fast = 1,slow = 1;
        while (fast < n){
            if (nums[fast] != nums[fast - 1]){
                nums[slow] = nums[fast];
                ++slow;
//                System.out.println(nums[slow] + " " + slow);
            }
            ++fast;
        }

        for (int i :
                nums) {
            System.out.println(i);
        }
        return slow;
    }
}
