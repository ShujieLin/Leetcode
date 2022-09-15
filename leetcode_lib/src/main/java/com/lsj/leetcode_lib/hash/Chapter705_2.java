package com.lsj.leetcode_lib.hash;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 设计哈希表大小为base = 769
 * 设计哈希函数：hash(x) = x mod base,x代表key，hash(x)代表插入的值
 * 开辟大小为base的数组，数组的每个元素是一个链表。
 *
 * @date: 2022/6/30
 * @author: linshujie
 */
public class Chapter705_2 {
    class MyHashSet {
        private static final int BASE = 769;
        private LinkedList<Integer>[] set;

        public MyHashSet() {
            set = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                set[i] = new LinkedList<Integer>();
            }
        }

        public void add(int key) {
            //找到桶的位置
            int bucketIndex = hash(key);
            //拿到迭代器
            Iterator<Integer> iterator = set[bucketIndex].iterator();
            while (iterator.hasNext()) {
//                if (!iterator.next().equals(key)){
//                    set[bucketIndex].offerLast(key);
//                }
//                int next = iterator.next();
                Integer next = iterator.next();
                if (next == key) {
                    return;
                }
            }
            set[bucketIndex].offerLast(key);
        }

        public void remove(int key) {
            //找到桶的位置
            int bucketIndex = hash(key);
            //拿到迭代器
            Iterator<Integer> iterator = set[bucketIndex].iterator();
            while (iterator.hasNext()) {
//                set[bucketIndex].remove(key);
                //注意！这里必须装箱，否则这里的remove会调用public E remove(int index)
                //正确的调用应该是这个方法： public boolean remove(Object o)
                Integer next = iterator.next();
                if (next == key) {
                    set[bucketIndex].remove(next);
                    return;
                }
            }
        }

        public boolean contains(int key) {
            //找到桶的位置
            int bucketIndex = hash(key);
            //拿到迭代器
            Iterator<Integer> iterator = set[bucketIndex].iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next == key) {
                    return true;
                }
            }
            return false;
        }

        private int hash(int key) {
            return key % BASE;
        }
    }
//java.lang.IndexOutOfBoundsException: Index: 2, Size: 1
//  at line 559, java.base/java.util.LinkedList.checkElementIndex
//  at line 529, java.base/java.util.LinkedList.remove
//  at line 38, MyHashSet.remove
//  at line 67, __Driver__.__helperSelectMethod__
//  at line 90, __Driver__.__helper__
//  at line 111, __Driver__.main

}
