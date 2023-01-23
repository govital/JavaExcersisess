package com.company;

import java.util.HashSet;
import java.util.List;

/**
139. Word Break
Given a string s and a dictionary of strings wordDict,
return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
*/

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null || s.isEmpty() || wordDict.isEmpty()){
            return false;
        }
        HashSet<String> hs = new HashSet<>();
        hs.add("");
        for(char c: s.toCharArray()){
            HashSet<String> nhs = new HashSet<>();
            for (String ss: hs){
                StringBuilder sb = new StringBuilder().append(ss) ;
                sb.append(c);
                nhs.add(sb.toString());
                if(wordDict.contains(sb.toString())){
                    nhs.add("");
                }
            }
            hs = new HashSet<>(nhs);
        }
        if (hs.contains(""))return true;
        return false;
    }
}
