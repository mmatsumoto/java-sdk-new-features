package org.examplee.java11;

public class _05String {
    public static void main(String[] args) {
        var m = "hello ".repeat(3);
        System.out.println(m);


        var s = "1\n2\n3\r4\n5";
        s.lines().forEach(System.out::println);

        //https://www.baeldung.com/java-11-string-api
        // strip() - remove full-width spaces
        System.out.println("|" + "\n\t  hello   \u2005".strip() + "|");
        // prints |hello|

        // strip vs trim,
        System.out.println("|" + "  hello   \u2005".trim() + "|");
        // prints |hello    |

        // isBlank()
        System.out.println("   ".isBlank());
    }
}
