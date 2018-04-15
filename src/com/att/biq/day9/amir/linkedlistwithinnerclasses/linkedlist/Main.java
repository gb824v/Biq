package com.att.biq.day9.amir.linkedlistwithinnerclasses.linkedlist;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(13);
        list.add(7);
        list.add(13);
        list.add(13);
        list.add(3);
        list.add(13);
        System.out.println(list);

        for(int val : list) {
            System.out.println(val);
        }

        // task1
//        list.remove(3);
//        System.out.println(list);

        // task2
//        list.removeAll(13);
//        System.out.println(list);

        MyList list2 = new MyList();
        System.out.println(list2);

        for(int val : list2) {
            System.out.println(val);
        }

        list2.add(3);
        System.out.println(list2);

        for(int val : list2) {
            System.out.println(val);
        }

        MyList.ListIterator itr;

    }
}
