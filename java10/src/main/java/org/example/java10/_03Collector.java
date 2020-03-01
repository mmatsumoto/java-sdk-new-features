package org.example.java10;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _03Collector {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(
                numbers.stream()
                        .filter(i -> i % 2 == 0)
                        .collect(Collectors.toUnmodifiableList())
                        .getClass()
        );

        System.out.println(
                numbers.stream()
                        .filter(i -> i % 2 == 0)
                        .collect(Collectors.toUnmodifiableSet())
                        .getClass()
        );

        System.out.println(
                numbers.stream()
                        .filter(i -> i % 2 == 0)
                        .collect(Collectors.toUnmodifiableMap(
                                Function.identity(), Object::toString))
                        .getClass()
        );

    }
}
