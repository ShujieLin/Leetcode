package com.shujie.test.gcroot;

/**
 * @author linshujie
 */
public class GCRootDemo3 {
    public static final GCRootDemo3 CONSTANT_GCROOT = new GCRootDemo3();

    public static void main(String[] args) {
        GCRootDemo3 object = new GCRootDemo3();

        object =  CONSTANT_GCROOT;

    }


}
