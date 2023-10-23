package com.shujie.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linshujie
 */
public class GroupAnagrams {
    public static void main(String[] args) {

    }

    static class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            //新建map
            Map<String,List<String>> hashmap = new HashMap<>();

            for (String str :
                    strs) {
                //获取key
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                //添加到list
                List<String> list = hashmap.getOrDefault(key, new ArrayList<String>());
                list.add(str);
                //添加到map
                hashmap.put(key,list);
            }
            return new ArrayList<>(hashmap.values());
        }
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<String, List<String>>();//用于存放数组的容器
            for (String str : strs) {
                //遍历每个str，把str的chars按照固定的顺序排序，作为hashmap的key。保证key的唯一性
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String key = new String(array);
                //通过key获取对应的list，并把当前str假如list
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                list.add(str);
                //添加当前list
                map.put(key, list);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }

    /*作者：力扣官方题解
    链接：https://leetcode.cn/problems/group-anagrams/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
