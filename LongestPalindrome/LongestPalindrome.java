package org.example.LongestPalindrome;

public class LongestPalindrome {

    public static void main(String[] args){
//        System.out.println(longestPalindrome("cdrrsstvsabasabasvtvdtvstvhev"));
//        System.out.println(longestPalindrome("cdrrsstvsabassabasvtvdtvstvhev"));
//        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ccc"));
    }

    private static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int longest = 0;
        int[] flags = new int[2];
        boolean evenp = true;
        String retval;
        /**odd palindrome*/
        for (int i =0; i < chars.length; i++) {
            if (((chars.length-i)*2) < longest) break;
            int offset=0,tempLong=0;
            while(i-offset > -1 && i+offset < chars.length && chars[i+offset]==chars[i-offset]){
                if(tempLong==0) tempLong = tempLong + 1; else tempLong = tempLong + 2;
                if (tempLong > longest){
                    evenp=false;
                    longest = tempLong;
                    flags[0]=i;
                    flags[1]=offset;
                }
                offset++;
            }
            /**Even palindrome*/
            offset=0;tempLong=0;
            while(i-offset > -1 && i+1+offset < chars.length && chars[i+1+offset]==chars[i-offset]){
                tempLong = tempLong + 2;
                if (tempLong > longest){
                    longest = tempLong;
                    evenp=true;
                    flags[0]=i;
                    flags[1]=offset;
                }
                offset++;
            }
        }
        if(evenp)retval = s.substring(flags[0]-flags[1], flags[0]+flags[1]+1+1);
        else retval = s.substring(flags[0]-flags[1], flags[0]+flags[1]+1);
        return retval;
    }

}
