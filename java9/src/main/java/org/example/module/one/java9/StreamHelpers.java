package org.example.module.one.java9;

import java.util.List;

/**
 * 5) Stream takeWhile, dropWhile
 */
class StreamHelpers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("takeWhile");
        // takeWhile
        numbers.stream()
                .takeWhile(e -> e < 5)
                .forEach(System.out::println);

        System.out.println("dropWhile");
        // dropWhile
        numbers.stream()
                .dropWhile(e -> e < 5)
                .forEach(System.out::println);
    }
}
