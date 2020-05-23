package com.gh.ds._11._07;

import com.gh.ds._11._07.map.LinkedListMap;

public class Demo04 {

    public static void main(String[] args) {

        LinkedListMap<Integer, String> map = new LinkedListMap<Integer, String>();

//        map.add(1, "11");
//        map.add(2, "2");
//        map.add(3, "33");
//        map.add(4, "44");
//        map.add(5, "5");

//        System.out.println(map.getSize());
//        System.out.println(map.get(3));
//        System.out.println(map.contains(4));
//        System.out.println(map.remove(3));
//        System.out.println(map.getSize());
//
//        System.out.println(map.contains(3));

//        System.out.println(map.get(4));
//        map.set(4, "44444");
//        System.out.println(map.get(4));
//        System.out.println(map.getSize());

        /**
         * 使用 map 结构统计词频
         */
        LinkedListMap<Integer, Integer> map1 = new LinkedListMap<Integer, Integer>();

        map1.set(0, 0);
        map1.set(1, 0);
        map1.set(2, 0);
        for (int i = 0; i < 999; i++) {

            if (i % 3 == 0) {
                map1.set(0, map1.get(0) + 1);
            } else if (i % 3 == 1) {
                map1.set(1, map1.get(1) + 1);
            } else {
                map1.set(2, map1.get(2) + 1);
            }
        }

        System.out.println(map1.get(0));
        System.out.println(map1.get(1));
        System.out.println(map1.get(2));

    }
}
