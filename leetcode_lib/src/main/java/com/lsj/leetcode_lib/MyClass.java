package com.lsj.leetcode_lib;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        /*MyClass myClass = new MyClass();
        System.out.println(myClass.test());*/

        Scanner scanner = new Scanner(System.in);
        /*if (scanner.hasNext()){
            String next = scanner.next();
        }*/
        if (scanner.hasNext()) {
            int i = scanner.nextInt();
            System.out.println(i);
        }else {
            System.out.println("error");
        }
        scanner.close();
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

    interface Person {
        void eat();
    }
}