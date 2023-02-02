package com.company.Strings;

public class CountAndSayPrblm {
    public static void main(String[] args) {

        int n = 4;
        System.out.println(countAndSay(n));
    }

    // TC = O(N)
    // SC = O(N)
    public static String countAndSay(int n) {
        if(n==1) return "1";

        String s = countAndSay(n-1);
        // we can also take res as String , but it will take more tym.
        StringBuilder res = new StringBuilder();

        int counter = 0;
        for(int i=0;i<s.length();i++){
            counter++;
            if(i==s.length()-1 || s.charAt(i)!=s.charAt(i+1)){
                res.append(counter).append(s.charAt(i));
                counter=0;
            }
        }
        return res.toString();
    }
}
