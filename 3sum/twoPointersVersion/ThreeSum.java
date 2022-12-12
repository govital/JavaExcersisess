package org.example.ThreeSum;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,0,-1,5,3,1,-7,4,22,-5,4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        List<List<Integer>> retval = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0; i < nums.length-1; i++) {
            List<Integer> temp = new ArrayList();
            if (i!=0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j < k) {
                if (nums[i]+nums[j]+nums[k] < 0){
                    j++;
                }else if (nums[i]+nums[j]+nums[k] > 0){
                    k--;
                }else{
                    temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                    retval.add(temp); break;
                }
            }
        }
        return retval;
    }

}
