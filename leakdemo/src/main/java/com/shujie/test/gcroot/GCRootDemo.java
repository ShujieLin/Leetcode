package com.shujie.test.gcroot;

/**
 * 虚拟机栈中引用的对象
 * @author linshujie
 */
public class GCRootDemo {
    public static void main(String[] args) {
        method();
    }

    /**
     * 虚拟机栈中引用的对象
     */
    private static void method() {
        Object object = new Object();//object作为gcroot
    }


}
