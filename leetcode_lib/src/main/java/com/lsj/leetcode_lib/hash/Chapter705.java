package com.lsj.leetcode_lib.hash;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @date: 2022/5/7
 * @author: linshujie
 */
public class Chapter705 {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(2);

    }

    static class MyHashSet{
        private static final int BASE = 769;
        private LinkedList[] data;

        /** Initialize your data structure here. */
        public MyHashSet() {

            //开辟一个base大小容量的数组，用于盛放桶
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; ++i) {
                //逐个存放空白的桶
                data[i] = new LinkedList<Integer>();
            }
        }

        /**
         * 我们通过哈希函数解析键，将它们映射到相应的桶中。
         * @param key
         */
        public void add(int key) {
            //通过哈希函数解析键
            int h = hash(key);
            //拿到key对应的value的迭代器
            Iterator<Integer> iterator = data[h].iterator();
            //通过迭代器遍历当前的value
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                //假如该key已经存在，则结束方法，不添加该key
                if (element == key) {
                    return;
                }
            }
            data[h].offerLast(key);
        }

        public void remove(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                if (element == key) {
                    data[h].remove(element);
                    return;
                }
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                if (element == key) {
                    return true;
                }
            }
            return false;
        }

        private static int hash(int key) {
            return key % BASE;
        }
    }

    }

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/design-hashset/solution/she-ji-ha-xi-ji-he-by-leetcode-solution-xp4t/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
