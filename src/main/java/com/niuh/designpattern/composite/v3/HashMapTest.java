package com.niuh.designpattern.composite.v3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("aa", 1);
        map1.put("bb", 2);
        map1.put("cc", 3);
        System.out.println("map1: " + map1);

        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("cc", 4);
        map2.put("dd", 5);
        System.out.println("map2: " + map2);

        map1.putAll(map2);
        System.out.println("map1.putAll(map2): " + map1);
    }

}
