//package com.shujie.datastructure;
//
//
//import java.util.Scanner;
//
//public class MyClass {
//    public static void main(String[] args) {
//        ArrayStack stack = new ArrayStack(4);
//        String key = "";
//        boolean loop = true;
//        Scanner scanner = new Scanner(System.in);
//        while (loop) {
//            System.out.println("show:show the stack");
//            System.out.println("exit：exit the program");
//            System.out.println("push：push a number in the stack");
//            System.out.println("pop：get out a number from the stack");
//            System.out.println("please choose a selection");
//            if (scanner.hasNext()) {
//                key = scanner.next();
//            }else {
//                System.out.println("you enter nothing");
//            }
////            scanner.next();
//            switch (key) {
//                case "show":
//                    stack.list();
//                    break;
//                case "push":
//                    System.out.println("pls input a number");
//                    stack.push(scanner.nextInt());
//                    break;
//                case "pop":
//                    try {
//                        int result = stack.pop();
//                        System.out.println("the result be poped is :" + result);
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case "exit":
//                    scanner.close();
//                    loop = false;
//                    break;
//                default:
//                    break;
//            }
//
//        }
//    }
//}