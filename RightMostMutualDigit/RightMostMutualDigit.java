package com.company;

import java.util.*;
/**
two input nums are sorted acsendind order
*/
public class Main {

    public static void main(String[] args) {
	    int ans = solution(237, 1);
        System.out.println(ans);
    }

    public static int solution(int n1, int n2) {
        Set<Character> n1s = new HashSet();
        Set<Character> n2s = new HashSet();
        for (char c: String.valueOf(n1).toCharArray()) n1s.add(c);
        for (char c: String.valueOf(n2).toCharArray()) n2s.add(c);

        if (n1s.size()>1 && n2s.size()>1) {
            int next = solution(
                    Integer.parseInt(n1s.toString().replaceAll("[ ,\\[\\]]", "").substring(1)),
                    Integer.parseInt(n2s.toString().replaceAll("[ ,\\[\\]]", "").substring(1)));
            if (next>-1){return next;}
        }

        for(Character c: n1s){if (n2s.contains(c)) return Integer.parseInt(c.toString());}
        return -1;
    }


}
