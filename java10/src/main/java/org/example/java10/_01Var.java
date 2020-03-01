package org.example.java10;

import java.util.HashMap;
import java.util.List;

public class _01Var {

    public static void main(String[] args) {

        var message = "hallo java 10";

        System.out.println(message);

        // goot to avoid all <<<>>>
        HashMap<Integer, List<Integer>> map1 = new HashMap<Integer, List<Integer>>();
        // like this
        var map2 = new HashMap<Integer, List<Integer>>();

    }
}
