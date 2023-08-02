package com.lsj.leetcode_lib.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: linshujie
 */
public class JZ007 {
    public static void main(String[] args) {

        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        int[] nums2 = new int[]{-2,0,0,2,2};
        List<List<Integer>> lists = new Solution().threeSum(nums2);
        System.out.println("lists = " + Arrays.toString(lists.toArray()));

    }

    /**
     * 要找出满足条件的不重复三元组，可以使用双指针法。首先对数组进行排序，然后使用两个指针，一个指向当前元素的下一个元素，另一个指向数组末尾。我们可以固定一个元素，然后在剩余的数组中使用双指针来找到和为零的三元组。
     *
     * 具体步骤如下：
     *
     * 对数组 nums 进行排序。
     * 遍历排序后的数组 nums，对于每个元素 nums[i]，将其作为固定元素。
     * 使用双指针 left 和 right，其中 left 初始为 i+1，right 初始为数组末尾。
     * 在 left < right 的条件下，执行以下步骤：
     * a. 计算当前三元组的和 sum = nums[i] + nums[left] + nums[right]。
     * b. 如果 sum 等于零，则将 [nums[i], nums[left], nums[right]] 加入结果列表，并继续查找下一个可能的解。
     * c. 如果 sum 小于零，则说明需要增大和，因此将 left 右移一位。
     * d. 如果 sum 大于零，则说明需要减小和，因此将 right 左移一位。
     * e. 注意处理重复元素，使得结果中不包含重复的三元组。
     * 继续遍历下一个固定元素，重复步骤 3 和步骤 4，直到遍历完所有元素。
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            System.out.println("nums = " + Arrays.toString(nums));

            //比较
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1,
                        right = nums.length - 1;
                //i重复，跳过
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    //int totalSum = nums[i] + nums[left] + nums[right];
                    System.out.println("sum = " + sum + " i = " + i + " left = " + left + " right"
                            + " = " + right);
                    if (sum == 0) {
                        List<Integer> subRes = new ArrayList<>();
                        subRes.add(nums[i]);
                        subRes.add(nums[left]);
                        subRes.add(nums[right]);
                        res.add(subRes);

                        //left重复，跳过
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        //right重复，跳过
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return res;
        }
    }

    static class ThreeSum {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            int n = nums.length;

            for (int i = 0; i < n - 2; i++) {
                // Skip duplicates for the first element
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = n - 1;

                while (left < right) {
                    int totalSum = nums[i] + nums[left] + nums[right];
                    System.out.println(
                            "totalSum = " + totalSum + " i = " + i + " left = " + left + " right"
                                    + " = " + right);

                    if (totalSum == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        result.add(triplet);

                        // Skip duplicates for the second element
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Skip duplicates for the third element
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (totalSum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return result;
        }
    }
}
