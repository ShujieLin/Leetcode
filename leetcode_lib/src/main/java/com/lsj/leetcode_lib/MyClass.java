package com.lsj.leetcode_lib;

public class MyClass {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(myClass.test());
    }

    private Person test() {
        final int[] age = new int[1];
        age[0] = 10;
        System.out.println(age[0]);
        return new Person() {
            private int i = 1;
            @Override
            public void eat() {
                age[0] += i;
            }
        };
    }

    interface Person{
        void eat();
    }
}