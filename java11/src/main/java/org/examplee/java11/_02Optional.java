package org.examplee.java11;

import java.util.Optional;

public class _02Optional {

    public static void printOptional(Integer i) {
        System.out.println("isEmpty: " +
                Optional.ofNullable(i).isEmpty());
    }

    public static void main(String[] args) {
        printOptional(10);
        printOptional(null);
    }
}
