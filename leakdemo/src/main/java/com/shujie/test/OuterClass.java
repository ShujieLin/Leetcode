package com.shujie.test;

/**
 * @author linshujie
 */
public class OuterClass {
    private String data;

    public OuterClass(String data) {
        this.data = data;
    }

    public class InnerClass {
        public void doSomething() {
            // 内部类访问外部类
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass("Hello");
        InnerClass inner = outer.new InnerClass();

        // 内部类实例持有对外部类实例的引用
        // 如果不小心保留内部类实例，外部类实例不会被垃圾回收
        // 内存泄漏潜在地发生在这里
        inner.doSomething();

        // 如果不再需要内部类实例，应该将其引用置为null，以便垃圾回收
        inner = null;
    }
}
