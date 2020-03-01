package org.example.java10;

import java.util.Optional;

public class _04Optional {

    public static void printOptional(Integer i) {
        var opt = Optional
                .ofNullable(i)
                .orElseThrow(() -> new RuntimeException("No element!"));

        System.out.println(opt);
    }

    public static void main(String[] args) {
        printOptional(10);

        try {
            printOptional(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
