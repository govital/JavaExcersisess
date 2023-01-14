package com.company;

import java.util.*;
import java.util.stream.Collectors;


/**
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
*/

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> lists = permute(new int[]{0,-1,1});
        for (List<Integer> list: lists){
            System.out.println(list);
        }
        System.out.println(lists.size());
    }

    public static List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        List<List<Integer>> res1 = new ArrayList();
         permute(new ArrayList(), Arrays.stream(nums).boxed().collect(Collectors.toList()), res);
         for(List<Integer> l: res){
             res1.add(l);
         }
        return res1;
    }

    private static void permute(List<Integer> prefix, List<Integer> str, Set<List<Integer>> perms) {
        if(str == null || str.isEmpty()) {
            if(prefix.isEmpty())return;
            perms.add(prefix);
            return;
        }
        for(int i=0; i< str.size(); i++){
            List<Integer> strNew = new ArrayList(str);
            List<Integer> prefixNew = new ArrayList(prefix);
            prefixNew.add(str.get(i));
            strNew.remove(i);
            permute(prefixNew, strNew, perms);
        }
    }


}
