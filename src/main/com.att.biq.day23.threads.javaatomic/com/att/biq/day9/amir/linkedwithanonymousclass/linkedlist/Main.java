package com.att.biq.day9.amir.linkedwithanonymousclass.linkedlist;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(7);
        list.add(17);
        list.add(72);
        list.add(13);
        list.add(3);
        list.add(13);
        list.add(5);
        System.out.println(list);

//        for(int val : list) {
//            System.out.println(val);
//        }

        Iterator<Integer> itr = list.iterator();
        int max = itr.next();
        while (itr.hasNext()) {
            int val = itr.next();
            if (val > max) {
                max = val;
            }
        }
        System.out.println("max = " + max);
    }
}
