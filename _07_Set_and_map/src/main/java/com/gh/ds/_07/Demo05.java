package com.gh.ds._07;

import com.gh.ds._07.map.BstMap;

public class Demo05 {

    public static void main(String[] args) {

        BstMap<Integer, Integer> map1 = new BstMap<Integer, Integer>();

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

        System.out.println(map1.getSize());


    }
}
