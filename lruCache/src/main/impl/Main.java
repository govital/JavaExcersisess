package lruCache.src.main.impl;

import lruCache.src.main.impl.CacheNode;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        LruCache cache = new LruCache(3);
        cache.set(3, "3");
        cache.set(2, "2");
        cache.get(3);
        cache.set(1, "1");
        cache.set(4, "4");
        cache.print();
    }

}









