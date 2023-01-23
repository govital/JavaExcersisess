package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] unMerged = new int[5][2];
        unMerged[0] = new int[2];
        unMerged[0][0]= 1;unMerged[0][1]= 4;
        unMerged[1] = new int[2];
        unMerged[1][0]= 0;unMerged[1][1]= 1;
        unMerged[2] = new int[2];
        unMerged[2][0]= 6;unMerged[2][1]= 7;
        unMerged[3] = new int[2];
        unMerged[3][0]= 8;unMerged[3][1]= 9;
        unMerged[4] = new int[2];
        unMerged[4][0]= 1;unMerged[4][1]= 10;
        int[][] merged = solution.merge(unMerged);
        System.out.println(Arrays.deepToString(merged));
    }
}
*/

public class Solution {

    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0){
            return new int[0][2];
        }
        if(intervals.length==1){
            return intervals;
        }
        List<int[]> intervalsl = new ArrayList();
        Collections.addAll(intervalsl, intervals);
        List<int[]> list = new ArrayList();
        list.add(intervalsl.get(0));
        intervalsl.remove(0);
        while(!intervalsl.isEmpty()){
            int[] curReq = intervalsl.get(0);
            intervalsl.remove(0);
            for (int j=0;j<list.size();j++){
                if(curReq[0]<=list.get(j)[0]){
                    list.add(j,curReq);
                    break;
                }
                if(j==list.size()-1){
                    list.add(curReq);
                    break;
                }

            }
        }

        int changes=1;
        while(changes>0){
            changes=0;
            for (int j=0;j<list.size()-1;j++){
                if(list.get(j)[1]>=list.get(j+1)[1]){
                    list.remove(j+1);
                    changes++;
                    break;
                }
                if(list.get(j)[1]>=list.get(j+1)[0]){
                    list.get(j)[1]=list.get(j+1)[1];
                    list.remove(j+1);
                    changes++;
                    break;
                }
                if(list.get(j)[0]==list.get(j+1)[0]){
                    list.remove(j);
                    changes++;
                    break;
                }
            }
        }

        return list.toArray(new int[list.size()][2]);
    }
}
