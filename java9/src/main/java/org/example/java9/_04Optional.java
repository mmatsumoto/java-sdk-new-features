package org.example.java9;

import java.util.List;
import java.util.Optional;

/**
 * 7) Optional changes
 */
class _04Optional {
    public static void ifPresentOrElse() {
        printOptional(1);
        printOptional(null);
    }

    private static void printOptional(Integer value) {
        Optional<Integer> opt = Optional.ofNullable(value);
        System.out.println("Optional: " + opt);
        opt.ifPresentOrElse(
                e -> System.out.println("e: " + e),
                () -> System.out.println("I don't have value"));
    }

    public static void or() {
        System.out.println(Optional.of(10)
                .or(() -> Optional.of(1)));

        System.out.println(Optional.empty()
                .or(() -> Optional.of(1)));
    }

    public static void optionalStream() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream().filter(e -> e % 2 == 0)
                .findFirst() // return a optional
                .stream() // stream of one element
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        ifPresentOrElse();

        or();

        optionalStream();
    }
}
