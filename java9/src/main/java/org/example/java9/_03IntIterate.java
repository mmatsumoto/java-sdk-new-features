package org.example.java9;

import java.util.stream.IntStream;

/**
 * 6) IntStream.iterate
 */
class _03IntIterate {
    public static void main(String[] args) {
        System.out.println("iterate (seed, predicate, operator)");
        IntStream.iterate(0, i -> i < 5, i -> i + 1)
                .forEach(System.out::println);

        System.out.println("iterate infinite");
        IntStream.iterate(0, i -> i + 1)
                .limit(5)
//                .takeWhile(i -> i < 10)
                .forEach(System.out::println);
    }
}
