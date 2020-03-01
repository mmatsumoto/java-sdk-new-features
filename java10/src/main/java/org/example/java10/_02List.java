package org.example.java10;

import java.util.Arrays;
import java.util.List;

public class _02List {
    public static void main(String[] args) {
        // mutable
        var numbers1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // immutable
        var numbers2 = List.copyOf(numbers1);

        System.out.println(numbers1 == numbers2);
        System.out.println(numbers1.equals(numbers2));
        System.out.println(numbers1.getClass());
        System.out.println(numbers2.getClass());

        // does not make a copy in this case share immutable reference / print true
        System.out.println(numbers2 == List.copyOf(numbers2));

        // also for Set
        // Set.copyOf(numbers2);

        // na map
        // Map.copyOf(otherMap)
    }
}
