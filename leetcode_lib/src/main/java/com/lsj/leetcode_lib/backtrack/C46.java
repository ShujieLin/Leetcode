package com.lsj.leetcode_lib.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linshujie
 */
public class C46 {
    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution2().permute(new int[]{1, 2, 3});
        System.out.println("Arrays.toString(permute.toArray()) = " + Arrays.toString(permute.toArray()));
    }

    /**
     * 思路：
     * 回溯
     * 1.选择列表
     * 2.前进，添加到path容器
     * 3.后退,从path容器中删除
     * 4.触底，添加到结果容器
     */
    static class Solution2 {
        private List<List<Integer>> res;

        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> path = new LinkedList<>();
            res = new ArrayList<>();
            boolean[] isRead = new boolean[nums.length];
            backstack(nums, path, isRead);
            return res;
        }

        private void backstack(int[] nums, LinkedList<Integer> path, boolean[] isRead) {
            //判断触底
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                System.out.println(" 触底 " );
            }

            for (int i = 0; i < nums.length; i++) {
                //添加判断，是否走过
                if (isRead[i]) {
                    continue;
                }

                //前进
                path.addLast(nums[i]);
                isRead[i] = true;
                System.out.println("path = " + Arrays.toString(path.toArray()));

                //回溯
                backstack(nums, path, isRead);

                //后退
                path.removeLast();
                isRead[i] = false;
            }
        }
    }

    static class Solution {
        List<List<Integer>> res = new LinkedList<>();

        /* 主函数，输入一组不重复的数字，返回它们的全排列 */
        List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            LinkedList<Integer> track = new LinkedList<>();
            // 「路径」中的元素会被标记为 true，避免重复使用
            boolean[] used = new boolean[nums.length];

            backtrack(nums, track, used);
            return res;
        }

        int ceng = 0;

        // 路径：记录在 track 中
        // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
        // 结束条件：nums 中的元素全都在 track 中出现
        void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
            /*System.out.println(" ========================== " );*/
            System.out.println("---------------------------ceng = " + ++ceng);
            // 触发结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 排除不合法的选择
                if (used[i]) {
                    // nums[i] 已经在 track 中，跳过
                    continue;
                }

                // 做选择
                track.add(nums[i]);
                used[i] = true;
                System.out.println("add  = " + Arrays.toString(track.toArray()));

                /*System.out.println("add : nums[" + i + "] = " + nums[i] + " used = true" );*/
                // 进入下一层决策树
                backtrack(nums, track, used);

                // 取消选择
                track.removeLast();
                used[i] = false;
                System.out.println("remove = " + Arrays.toString(track.toArray()));

            }
            System.out.println("---------------------------ceng = " + --ceng);
        }
    }

}