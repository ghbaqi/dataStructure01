package com.gh.ds._07;

public class Demo02 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(5);
        list.addLast(4);
        list.addLast(2);
        list.addLast(4);
        list.addLast(3);

        System.out.println(list.getSize());

        list.removeElement(5);
        System.out.println(list.getSize());

        list.removeElement(4);
        System.out.println(list.getSize());

        list.removeElement(4);
        System.out.println(list.getSize());

        list.removeElement(300);
        System.out.println(list.getSize());
    }

}
