package org.example.module.one.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 3) List.of, Set.of, Map.of
 */
class OfHelpers {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);

        // of returns immutable representation, the code bellow throw exceptions
        // integers.add(1);
        // integers.set(0, 1);

        System.out.println(integers);

        System.out.println(Set.of(1, 2, 3, 4));
        System.out.println(Map.of("k1", "v1", "k2", "v2"));
    }
}
