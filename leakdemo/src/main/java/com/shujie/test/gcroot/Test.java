package com.shujie.test.gcroot;

/**
 * @author linshujie
 */
public class Test {
    public static Test s;
    public static  void main(String[] args) {
        Test a = new Test();
        a.s = new Test();
        a = null;
    }
}
