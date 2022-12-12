package org.example;

import javax.naming.SizeLimitExceededException;
import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 */
public class LRUCache {
    private static Map<String, Node> cache = new HashMap();
    private static String first = "-1";
    private static String last = "-1";
    private static int size = 0;

    public LRUCache(int size) throws SizeLimitExceededException {
        if (size < 1) {
            throw new SizeLimitExceededException("LRUCache Size must be greater then 0");
        }
        LRUCache.size = size;
    }


    public static void main( String[] args ) throws SizeLimitExceededException {
        System.out.println( "Hello World!" );
        LRUCache lruCache = new LRUCache(2);
        set("null", "ttt");
        System.out.println(get(null));
        set("w", "tt3t");
        set("d", "ttet");
        set("r", "ttdt");
        System.out.println(cache.get(first).value);
    }


    public static String get( String key ) {

        if (cache.containsKey(key)) {
            moveNodeToFirstInLine(key);
            return cache.get(key).value;
        }
        return "-1";
    }

    private static void moveNodeToFirstInLine( String key ) {
        cache.get(cache.get(key).previouse).next = cache.get(key).next;
        cache.get(cache.get(key).next).previouse = cache.get(key).previouse;
        cache.get(first).previouse = key;
        cache.get(key).previouse = null;
        cache.get(key).next = first;
        first = key;
    }

    private static void insertFirstInLine( String key ) {
        cache.get(cache.get(key).previouse).next = cache.get(key).next;
        cache.get(cache.get(key).next).previouse = cache.get(key).previouse;
        cache.get(first).previouse = key;
        cache.get(key).previouse = null;
        cache.get(key).next = first;
        first = key;
    }

    public static void set( String key, String value ) {
        if (key == null) {
            throw new RuntimeException("null is not allowed to set as key");
        }
        if (cache.size() == size) {
            String newLast = cache.get(last).previouse;
            cache.get(newLast).next = null;
            cache.remove(last);
            last = newLast;
        }
        Node newFirstNode = new Node();
        newFirstNode.key = key;
        newFirstNode.value = value;
        if (cache.size() < size && cache.size() > 0) {
            cache.get(first).previouse = key;
            newFirstNode.next = first;
        }else{
            last = key;
        }
        first = key;
        cache.put(key, newFirstNode);
    }


}
