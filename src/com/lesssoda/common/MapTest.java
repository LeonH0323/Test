package com.lesssoda.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Lee
 * @since 2021/5/5 22:33
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

//        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Integer, String> next = iterator.next();
//            System.out.println(next.getKey());
//            System.out.println(next.getValue());
//        }

//        map.forEach((key, value) -> {
//            System.out.println(key);
//            System.out.println(value);
//        });

        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
}
