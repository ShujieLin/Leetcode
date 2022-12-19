package com.shujie.datastructure.recursion;

/**
 * @author: linshujie
 */
public class RecursionTest {
    public static void main(String[] args) {
        test2(4);
    }

    private static void test(int i) {
        if (i > 2) {
            test(i - 1);
        }
        System.out.println("i = " + i);
    }

    private static void test2(int i) {
        if (i > 2) {
            test2(i - 1);
        } else {
            System.out.println("i = " + i);
        }
    }
}
