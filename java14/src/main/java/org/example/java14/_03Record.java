package org.example.java14;

public class _03Record {
    public static void main(String[] args) {
        var point = new Point(1, 2);

        System.out.println(point);
        System.out.println(point.x());
        System.out.println(point.y());
        System.out.println(point.hashCode());
        System.out.println(point.toString());

        System.out.println((new Point(1,2)).equals(point));
    }
}

record Point(int x, int y) {}

