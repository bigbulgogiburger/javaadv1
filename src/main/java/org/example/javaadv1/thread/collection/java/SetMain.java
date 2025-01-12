package org.example.javaadv1.thread.collection.java;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {


    public static void main(String[] args) {
        Set<Integer> copySet = new CopyOnWriteArraySet<>();

        copySet.add(1);
        copySet.add(2);
        copySet.add(3);
        System.out.println("copySet = " + copySet);

        Set<Object> skipSet = new ConcurrentSkipListSet<>();
        copySet.add(3);
        copySet.add(1);
        copySet.add(2);
        System.out.println("copySet = " + copySet);

    }
}
