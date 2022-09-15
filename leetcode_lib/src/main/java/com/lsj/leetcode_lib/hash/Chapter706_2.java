package com.lsj.leetcode_lib.hash;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @date: 2022/7/2
 * @author: linshujie
 */
public class Chapter706_2 {
    class MyHashMap {
        private static final int BASE = 769;
        private LinkedList[] hashMap;

        class Pair {
            private int key;
            private int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public void setKey(int key) {
                this.key = key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }


        public MyHashMap() {
            hashMap = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                hashMap[i] = new LinkedList<Pair>();
            }
        }

        public void put(int key, int value) {
            int bucketIndex = hash(key);
            Iterator<Pair> iterator = hashMap[bucketIndex].iterator();
            //更新value
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    pair.setValue(value);
                    return;
                }
            }
            //new 元素
            hashMap[bucketIndex].offerLast(new Pair(key, value));
        }

        public int get(int key) {
            int bucketIndex = hash(key);
            Iterator<Pair> iterator = hashMap[bucketIndex].iterator();
            //更新value
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    return pair.value;
                }
            }
            return -1;
        }

        public void remove(int key) {
            int bucketIndex = hash(key);
            Iterator<Pair> iterator = hashMap[bucketIndex].iterator();
            //更新value
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    hashMap[bucketIndex].remove(pair);
                    return;
                }
            }
        }

//        private int hash(int key) {
//            return BASE % key;
//        }

        private int hash(int key) {
            return key % BASE;
        }
    }
}
