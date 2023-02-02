package com.company.Strings;

import java.util.Arrays;

public class ShuffledSubstring {
    public static void main(String[] args) {

        String str1 = "onetwofour",str2 = "hellofourtwooneworld";
        System.out.println(validShuffleString(str1,str2));

        String str3 = "roseyellow", str4 = "yellow";
        System.out.println(validShuffleString(str3,str4));

    }

    // N -> s1.length(), M-> s2.length()
    // TC = O(N log N + M log M + M)
    // SC = O(M)
    public static boolean validShuffleString(String s1, String s2){
        if(s1.length()>s2.length()) return false;
        s1= sortString(s1);
        s2= sortString(s2);
        System.out.println(s1 + "  "+s2);
        int k=0;
        int count=0;
        for (int i=0;i<s2.length() && k<s1.length();i++){
            if(s2.charAt(i)==s1.charAt(k)) {
                k++;
                count++;
            }
        }
        if(count==s1.length()) return true;
        return false;
    }

    // Sort String
    public static String sortString(String s)
    {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
