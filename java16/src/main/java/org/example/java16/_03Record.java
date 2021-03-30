package org.example.java16;

import java.awt.*;
import java.util.List;

public class _03Record {

    public static void main(String[] args) {
        var point = new Point(1, 2);

        System.out.println(point);
        System.out.println(point.x());
        System.out.println(point.y());
        System.out.println(point.hashCode());
        System.out.println(point.toString());

        System.out.println((new java.awt.Point(1,2)).equals(point));


        var range = new Range(1, 2);
        System.out.println(range);


        try {
            range = new Range(2, 1);
            System.out.println(range);
        } catch (Exception e) {
            System.out.println("custom constructor fail: " + e.getMessage());
        }
    }

    public static void localRecords() {
        record Price(int p) {}

        List.of(1,2,3).stream()
                .map(Price::new)
                .forEach(System.out::println);
    }

}

record Point(int x, int y) {}

record Range(int lo, int hi) {
    Range {
        if (lo > hi) {
            throw new IllegalArgumentException("lo > hi");
        }
    }
}

