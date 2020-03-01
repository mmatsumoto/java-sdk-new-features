package org.example.java9;

import lombok.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 8) Collectors
 * https://www.baeldung.com/java9-stream-collectors
 */
class _05Collectors {
    public static void filtering() {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 3, 5, 5, 6);

        // no java 9, just to understand the difference from stream filter and Collectors filtering
        Map<Integer, Long> result = numbers.stream()
                .filter(val -> val > 3)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(result);
        // prints {5=2, 6=1}

        result = numbers.stream()
                .collect(Collectors.groupingBy(i -> i,
                        Collectors.filtering(val -> {
                            System.out.println("val " + val);
                            return val > 3;
                        }, Collectors.counting())));
        System.out.println(result);
        // prints: {1=0, 2=0, 3=0, 5=2, 6=1}
        // the count on 1, 2, and 3 is not incremented because val > 3 is false
    }

    public static void flatMapping() {
        List<ColorFruit> colorFruits = List.of(
                new ColorFruit("red", List.of("apple", "strawberry")),
                new ColorFruit("yellow", List.of("banana", "manga"))
        );

        // without flatMapping - List of List<String>
        Map<String, List<List<String>>> colorFruits1 = colorFruits.stream()
                .collect(Collectors.groupingBy(ColorFruit::getColor,
                        Collectors.mapping(ColorFruit::getFruits, Collectors.toList())));
        System.out.println(colorFruits1);
        //prints: {red=[[apple, strawberry]], yellow=[[banana, manga]]}

        Map<String, List<String>> colorFruits2 = colorFruits.stream()
                .collect(Collectors.groupingBy(ColorFruit::getColor,
                        Collectors.flatMapping(c -> c.getFruits().stream(), Collectors.toList())));
        System.out.println(colorFruits2);
        // prints: {red=[apple, strawberry], yellow=[banana, manga]}
    }

    public static void main(String[] args) {
        filtering();

        flatMapping();
    }
}

@Value
class ColorFruit {
    public String color;
    public List<String> fruits;
}

