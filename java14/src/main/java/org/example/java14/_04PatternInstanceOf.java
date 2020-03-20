package org.example.java14;

public class _04PatternInstanceOf {
    public static void main(String[] args) {

        /*
           Motivation:
            if (obj instanceof String) {
                String s = (String) obj;
                // use s
            }
         */

        Object obj = "something";
        if (obj instanceof String s) {
            s.toUpperCase();
        } else {
            // can't use s here
        }


    }
}
