package com.lsj.leetcode_lib.jianzhi;

import java.util.List;

/**
 * @author: linshujie
 */
public class JZ007 {
    public static void main(String[] args) {

    }

    /**
     *
     要找出满足条件的不重复三元组，可以使用双指针法。首先对数组进行排序，然后使用两个指针，一个指向当前元素的下一个元素，另一个指向数组末尾。我们可以固定一个元素，然后在剩余的数组中使用双指针来找到和为零的三元组。

     具体步骤如下：

     对数组 nums 进行排序。
     遍历排序后的数组 nums，对于每个元素 nums[i]，将其作为固定元素。
     使用双指针 left 和 right，其中 left 初始为 i+1，right 初始为数组末尾。
     在 left < right 的条件下，执行以下步骤：
     a. 计算当前三元组的和 sum = nums[i] + nums[left] + nums[right]。
     b. 如果 sum 等于零，则将 [nums[i], nums[left], nums[right]] 加入结果列表，并继续查找下一个可能的解。
     c. 如果 sum 小于零，则说明需要增大和，因此将 left 右移一位。
     d. 如果 sum 大于零，则说明需要减小和，因此将 right 左移一位。
     e. 注意处理重复元素，使得结果中不包含重复的三元组。
     继续遍历下一个固定元素，重复步骤 3 和步骤 4，直到遍历完所有元素。
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

        }
    }


}
