package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
