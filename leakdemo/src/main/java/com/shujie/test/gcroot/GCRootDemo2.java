package com.shujie.test.gcroot;

/**
 * 方法区中类静态属性引用的对象
 *
 * @author linshujie
 */
public class GCRootDemo2 {
    private static Woker woker = new Woker();

    public static void main(String[] args) {
        GCRootDemo2 object = new GCRootDemo2();
        object.setStaticObject(woker);
        object = null;
        gc();
        if (object != null) {
            object.printOwn();
        } else {
            System.out.println("null");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void setStaticObject(Woker woker) {
    }

    void printOwn() {
        System.out.println("this = " + this);
    }

    private static void gc() {
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Woker {
}
