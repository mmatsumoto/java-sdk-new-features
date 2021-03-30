package org.example.java15;

public class _02String {
    public static void main(String[] args) {
        var s = """
    line1
    line2
        line3
""";

        System.out.println(s);


        var s2 = """
                there's no new line here \
                this is just to improve readability
                """;
        System.out.println(s2);
    }
}
