package org.examplee.java11;

import java.util.*;

public class _01VarLambdas {
    public static void main(String[] args) {
        final var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                // you can use Annotations and keywords like 'final
                .filter((var i) -> i % 2 == 0)
                .forEach(System.out::println);

    }
}