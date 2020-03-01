package org.examplee.java11;

import java.util.List;

import static java.util.function.Predicate.not;

public class _04PredicateNot {
    public static boolean isEven(int n)  {
        return n % 2 == 0;
    }

    public static void main(String[] args) {

        final var numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
                .filter(not(_04PredicateNot::isEven))
                .forEach(System.out::println);


    }
}
