package org.example.Permutations;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return Collections.emptyList();
        }
        List<Node> current = new ArrayList();
        /**populate root nodes*/
        for (int i = 0; i < nums.length;i++) {
            Node node = new Node();
            node.path = new ArrayList<>();
            node.path.add(nums[i]);
            node.remaining = IntStream.of(nums).boxed().collect(Collectors.toList());
            node.remaining.remove(node.remaining.get(i));
            current.add(node);
        }

        /**create pormutation trees*/
        List<Node> next = new ArrayList();
        List<List<Integer>> paths = new ArrayList<>();
        while (!current.isEmpty()) {
            Node cn = current.get(0);
            current.remove(0);
            if (cn.remaining == null || cn.remaining.isEmpty()) {
                paths.add(cn.path);
                continue;
            }

            for (Integer n: cn.remaining) {
                Node nn = new Node();
                nn.remaining = new ArrayList<>(cn.remaining);
                nn.remaining.remove(n);
                nn.path = new ArrayList<>(cn.path);
                nn.path.add(n);
                next.add(nn);
            }
            if (current.isEmpty() && !next.isEmpty()) {
                current = new ArrayList(next);
                next = new ArrayList();
            }
        }
        return paths;

    }



    static class Node {
        List<Integer> remaining;
        List<Integer> path;
    }

}
