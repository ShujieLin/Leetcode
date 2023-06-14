package com.lsj.leetcode_lib.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author: linshujie
 */
public class C139 {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        new Solution().wordBreak("leetcode",list);*/

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        new MySolution().wordBreak("applepenapple", list);
    }

    static class MySolution {

        private int[] mem;

        public boolean wordBreak(String s, List<String> wordDict) {

            //通过遍历字典，截取字典里面的单词和截取后s对比，存在相同则进行下一个递归
            //查找到复合条件的进行返回
            //-1 ：未访问 0：失败 1：成功
            mem = new int[s.length() + 1];
            Arrays.fill(mem, -1);
            return dp(s, wordDict, 0);
        }

        private boolean dp(String s, List<String> wordDict, int i) {
            System.out.println("-> i = " + i);
            //假如i已经到达s的长度，说明找到可以对的上的单词
            if (i == s.length()) {
                System.out.println("<- true 1");
                return true;
            }

            //添加备忘录,访问过的，直接return
            if (mem[i] != -1){
                return mem[i] == 1;
            }

            for (String word :
                    wordDict) {
                int length = word.length();
                //长度不能超过s
                if (i + length > s.length()) continue;

                String substring = s.substring(i, i + length);

                //不存在，查询下一个
                if (!substring.equals(word)) {
                    continue;
                }

                //找到相同，进行下一步
                boolean res = dp(s, wordDict, i + length);
                if (res) {
                    //记录备忘录
                    System.out.println("<- true 2");
                    mem[i] = 1;
                    return true;
                }
            }

            mem[i] = 0;
            System.out.println("<- false");
            //找不到，返回false
            return false;
        }
    }

    static class Solution2 {
        // 用哈希集合方便快速判断是否存在
        HashSet<String> wordDict;
        // 备忘录，-1 代表未计算，0 代表无法凑出，1 代表可以凑出
        int[] memo;

        // 主函数
        public boolean wordBreak(String s, List<String> wordDict) {
            // 转化为哈希集合，快速判断元素是否存在
            this.wordDict = new HashSet<>(wordDict);
            // 备忘录初始化为 -1
            this.memo = new int[s.length()];
            Arrays.fill(memo, -1);
            return dp(s, 0);
        }

        // 定义：s[i..] 是否能够被拼出
        boolean dp(String s, int i) {
            System.out.println("->");
            // base case
            if (i == s.length()) {
                return true;
            }
            // 防止冗余计算
            if (memo[i] != -1) {
                return memo[i] != 0;
            }

            // 遍历 s[i..] 的所有前缀
            for (int len = 1; i + len <= s.length(); len++) {
                // 看看哪些前缀存在 wordDict 中
                String prefix = s.substring(i, i + len);
                System.out.println("prefix = " + prefix);
                if (wordDict.contains(prefix)) {
                    // 找到一个单词匹配 s[i..i+len)
                    // 只要 s[i+len..] 可以被拼出，s[i..] 就能被拼出
                    boolean subProblem = dp(s, i + len);
                    if (subProblem) {
                        memo[i] = 1;
                        return true;
                    }
                }
            }
            // s[i..] 无法被拼出
            memo[i] = 0;
            System.out.println("<-");
            return false;
        }
    }

    static class Solution {
        // 备忘录
        int[] memo;

        public boolean wordBreak(String s, List<String> wordDict) {
            // 备忘录，-1 代表未计算，0 代表 false，1 代表 true
            memo = new int[s.length()];
            Arrays.fill(memo, -1);
            // 根据函数定义，判断 s[0..] 是否能够被拼出
            return dp(s, 0, wordDict);
        }

        // 定义：返回 s[i..] 是否能够被 wordDict 拼出
        boolean dp(String s, int i, List<String> wordDict) {
            System.out.println("-> s = " + s + " i = " + i);
            // base case，整个 s 都被拼出来了
            if (i == s.length()) {
                System.out.println("<- return true 1");
                return true;
            }
            // 防止冗余计算
            if (memo[i] != -1) {
                System.out.println("<- return" + (memo[i] == 1 ? true : false) + " 2");
                return memo[i] == 1 ? true : false;
            }
            // 遍历所有单词，尝试匹配 s[i..] 的前缀
            for (String word : wordDict) {
                System.out.println("word = " + word);
                int len = word.length();
                if (i + len > s.length()) {
                    continue;
                }
                String subStr = s.substring(i, i + len);
                System.out.println("subStr = " + subStr);
                if (!subStr.equals(word)) {
                    continue;
                }
                // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
                if (dp(s, i + len, wordDict)) {
                    // s[i..] 可以被拼出，将结果记入备忘录
                    memo[i] = 1;
                    System.out.println("<- return true 3 ");
                    return true;
                }
            }
            // s[i..] 不能被拼出，结果记入备忘录
            memo[i] = 0;
            System.out.println("<- return false 4 ");
            return false;
        }
    }
    // 详细解析参见：
    // https://labuladong.github.io/article/?qno=139
}
