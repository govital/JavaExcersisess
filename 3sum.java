package org.example;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 *Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 */
public class App {
    private static int SUM = 0;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(
                Arrays.toString(threeSum(new int[]{-2, 2, 3, -1, 6, 2}).toArray())
        );
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        Set<String> validate = new HashSet<String>();
        for(int i=0; i< nums.length; i++) {
            for(int j=0; j< nums.length; j++) {
                if (j == i) continue;
                for(int k=0; k< nums.length; k++) {
                    if(i != j && i != k && k != j) {
                        if (nums[i]+nums[j]+nums[k] == SUM) {
                            int[] temp = new int[]{i,j,k};
                            Arrays.sort(temp);
                            if (!validate.contains(Arrays.toString(temp))) {
                                validate.add(Arrays.toString(temp));
                                output.add(Arrays.asList(nums[i],nums[j],nums[k]));
                            }
                        }
                    }
                }
            }
        }
        if (output.isEmpty()) return Collections.emptyList();
        return output;
    }


}
