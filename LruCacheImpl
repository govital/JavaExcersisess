package com.company;

import java.io.IOException;
import java.util.*;

public class Main {
    static Map<Integer,Node> q;
//    private static Map<Integer,Node> memory;
    static Integer qCounter;
    static Integer maxQ;
    static Integer tail;
    static Integer head;
    static Queue<Integer> emptySpotsQ;

    public static void main(String[] args) throws IOException {
        q = new HashMap<>();
//        memory = new HashMap<>();
        emptySpotsQ = new LinkedList<>();
        maxQ = 3;
        Main.set(33, "ef");
    }

    private static void get(Integer id) {
        int valLocation = q.get(id);
        Node node = memory.get(valLocation);
        String val = node.getVal();
        System.out.println("requested val is: " + val);
    }

    private static void set(Integer id, String val) {

    }
}



class LruCache {

    private Map<Integer, String> info;
    private Map<Integer, Integer> q;


    public String get(Integer id) {

        //manage queue
        // * take id out of its place in line.
        // * insert id to tail
        // * if queue limit reached: remove queue head ( from map also )
        //




        //return info
        return info.get(id);






    }


    private static void set(Integer id, String val) {

    }


    private String info;
    private Integer from;
    private Integer to;

    private Node Node(String info, Integer from, Integer to) {
        this.info = info;
        this.from = from;
        this.to = to;
        return this;
    }

    String getVal(Integer location) {

        int newTail;
        if (!Main.emptySpotsQ.isEmpty()) {
            newTail = Main.emptySpotsQ.peek();
            Main.emptySpotsQ.remove();
        }else {
            newTail = Main.tail + 1;
        }
        if (Main.maxQ == Main.qCounter) {
            Node oldTail = Main.q.get(Main.tail);
            newTail = Main.tail + 1;
            Main.emptySpotsQ.add(location);
            Main.emptySpotsQ.add(Main.tail);
            Main.tail = newTail;
            Main.q.put(newTail, this);
        }else {

        }
        return this.info;
    }


}





class Node {
    private String info;
    private Integer from;
    private Integer to;

    private Node Node(String info, Integer from, Integer to) {
        this.info = info;
        this.from = from;
        this.to = to;
        return this;
    }

    String getVal(Integer location) {

        int newTail;
        if (!Main.emptySpotsQ.isEmpty()) {
            newTail = Main.emptySpotsQ.peek();
            Main.emptySpotsQ.remove();
        }else {
            newTail = Main.tail + 1;
        }
        if (Main.maxQ == Main.qCounter) {
            Node oldTail = Main.q.get(Main.tail);
            newTail = Main.tail + 1;
            Main.emptySpotsQ.add(location);
            Main.emptySpotsQ.add(Main.tail);
            Main.tail = newTail;
            Main.q.put(newTail, this);
        }else {

        }
        return this.info;
    }


}
