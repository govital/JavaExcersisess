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

        List<Map<NodeKeys, List<Integer>>> next = new ArrayList();
        List<List<Integer>> paths = new ArrayList<>();
        /**populate root nodes*/
        for (int i = 0; i < nums.length;i++) {
            Map<NodeKeys, List<Integer>> node = new HashMap();
            node.put(NodeKeys.PATH, new ArrayList(Arrays.asList(nums[i])));
            node.put(NodeKeys.REMAINING, new ArrayList(IntStream.of(nums).boxed().collect(Collectors.toList())));
            node.get(NodeKeys.REMAINING).remove(i);
            next.add(node);
            /**create pormutation trees*/
            while (!next.isEmpty()) {
                Map<NodeKeys, List<Integer>> cn = next.get(0);
                next.remove(0);
                /**no remaining means its leafe node - so add path to paths*/
                if (cn.get(NodeKeys.REMAINING) == null || cn.get(NodeKeys.REMAINING).isEmpty()) {
                    paths.add(cn.get(NodeKeys.PATH));
                    continue;
                }
                for (Integer n: cn.get(NodeKeys.REMAINING)) {
                    Map<NodeKeys, List<Integer>> nn = new HashMap<>();
                    nn.put(NodeKeys.REMAINING, new ArrayList<>(cn.get(NodeKeys.REMAINING)));
                    nn.get(NodeKeys.REMAINING).remove(n);
                    nn.put(NodeKeys.PATH, new ArrayList<>(cn.get(NodeKeys.PATH)));
                    nn.get(NodeKeys.PATH).add(n);
                    next.add(nn);
                }
            }
        }
        return paths;
    }


}
