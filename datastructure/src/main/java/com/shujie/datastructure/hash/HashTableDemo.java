package com.shujie.datastructure.hash;

import java.util.Scanner;

/**
 * @author: linshujie
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add");
            System.out.println("list");
            System.out.println("exit application");

            /*if (scanner.hasNext()) */key = scanner.next();
            switch (key) {
                case "add":
//                    if (scanner.hasNext()){
                        System.out.println("输入id");
                        System.out.println("输入名字");
                        int id = scanner.nextInt();
                        String name = scanner.next();
                        Employee employee = new Employee(id, name);
                        hashTable.add(employee);
//                    }

                    break;
                case "list":
                    hashTable.list();
                    break;

                case "exit":
                    /*scanner.close();*/
                    System.exit(0);
                    break;
                default:
                    break;
            }

        }
    }
}

class HashTable {
    private EmployeeLinkedList[] linkedLists;
    private int size;

    public HashTable(int size) {
        linkedLists = new EmployeeLinkedList[size];
        for (int i = 0; i < size; i++) {
            linkedLists[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee employee) {
        int empLinkedListNumber = hashFun(employee.id);
        linkedLists[empLinkedListNumber].add(employee);
    }

    public void list() {
        for (EmployeeLinkedList e :
                linkedLists) {
            e.list();
        }
    }

    private int hashFun(int id) {
        return id % size;
    }
}


class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeLinkedList {
    private Employee head;

    public void add(Employee employee) {
        if (head == null) {
            head = employee;
            return;
        }

        //假如不是第一个，使用辅助指针定位到最后
        Employee curEmployee = head;
        while (curEmployee.next != null) {
            curEmployee = curEmployee.next;
        }
        //加入到最后
        curEmployee.next = employee;
    }

    public void list() {
        if (head == null) {
            System.out.println("空链表");
            return;
        }

        System.out.println("当前链表信息：");
        //假如不是第一个，使用辅助指针定位到最后
        Employee curEmployee = head;
        while (curEmployee.next != null) {
            curEmployee = curEmployee.next;
            System.out.println("curEmployee = " + curEmployee);
        }
    }
}