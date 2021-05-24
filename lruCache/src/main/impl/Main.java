package lruCache.src.main.impl;

import lruCache.src.main.impl.CacheNode;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static LruCache cache;

    public static void main(String[] args) throws IOException {
        Main.testOne();
        Main.testTwo();
        Main.testThree();
    }

    private static void testOne() {
        System.out.println("TEST 1");
        System.out.println("EXPECTED OUTPUT: HEAD-->3-->1-->4-->TAIL");
        cache = new LruCache(3);
        cache.set(3, "3");
        cache.set(2, "2");
        cache.get(3);
        cache.set(1, "1");
        cache.set(4, "4");
        cache.print();
    }

    private static void testTwo() {
        System.out.println("TEST 2");
        System.out.println("EXPECTED OUTPUT: HEAD-->3-->1-->4-->TAIL");
        cache = new LruCache(3);
        cache.get(3);
        cache.get(3);
        cache.set(3, "3");
        cache.set(2, "2");
        cache.get(3);
        cache.set(1, "1");
        cache.set(4, "4");
        cache.print();
    }

    private static void testThree() {
        System.out.println("TEST 3");
        System.out.println("EXPECTED OUTPUT: HEAD-->3-->1-->4-->TAIL");
        cache = new LruCache(3);
        cache.get(3);
        cache.get(3);
        cache.set(3, "3");
        cache.set(3, "3");
        cache.set(3, "3");
        cache.set(3, "3");
        cache.set(2, "2");
        cache.get(3);
        cache.set(1, "1");
        cache.set(4, "4");
        cache.set(4, "4");
        cache.set(4, "4");
        cache.set(4, "4");
        cache.print();
    }

}









