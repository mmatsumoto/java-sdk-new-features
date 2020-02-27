package org.example.module.one.java9;

/**
 * 2) private methods on interfaces
 */
interface PrivateMethodOnInterfaces {
    default void doSomething1() {
        System.out.println(privateMethod1());
    }

    static void doSomething2() {
        System.out.println(privateMethod2());
    }

    private int privateMethod1() {
        return 1;
    }

    private static int privateMethod2() {
        return 2;
    }
}