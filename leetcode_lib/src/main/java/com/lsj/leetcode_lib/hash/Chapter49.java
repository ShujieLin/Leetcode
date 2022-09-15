package com.lsj.leetcode_lib.hash;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 思路：
 * 同一组异位词的相同点为当且仅当字符串包含的字母相同。
 * 使用哈希表存储每一组字母异位词。其中键为每组字母异位词的标志；值为一组字母异位词列表。
 *
 * 做法：
 *
 * 遍历每个字符串，对字符串进行排序，排序后的字符串就是该字符串所在的字母异位词的标志。
 * 将当前字符串加入该异位词列表中。
 * 遍历全部字符串。
 *
 * @date: 2022/7/4
 * @author: linshujie
 */
public class Chapter49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                //排序字符串的字符，获取key
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String key = Arrays.toString(chars);

                List<String> stringList = map.getOrDefault(key,new ArrayList<String>());
                stringList.add(strs[i]);

                map.put(key,stringList);
            }

            return new ArrayList<>(map.values());
        }
    }
}
