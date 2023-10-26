package com.shujie.test.gcroot;

/**
 * 方法区中类静态属性引用的对象
 * @author linshujie
 */
public class GCRootDemo2 {
    private static Object object;
    public static void main(String[] args) {
        method();
    }

    private static void method() {
        object = new Object();

    }
}
