package com.company.Strings;

public class RotateString {
    public static void main(String[] args) {

        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s,goal));
        System.out.println(rotateString2(s,goal));

    }

    // TC = O(N)
    // SC = O(1)
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String s2=s+s;
        return (s2.contains(goal));
    }

    // TC = O(N)
    // SC = O(N)
    public static boolean rotateString2(String s, String goal) {

        if(s.length()!=goal.length()||s.indexOf(goal.charAt(0))==-1)return false;

        int index=-1;

        for(int i=0;i<s.length();i++){

            if(s.charAt(i)==goal.charAt(0)){
                String temp=s.substring(i,s.length());
                if(temp.equals(goal.substring(0,temp.length()))){
                    index=i;
                    break;
                }}
        }
        if(index==-1)return false;

        String temp=s.substring(index,s.length());
        temp+=s.substring(0,index);
        return temp.equals(goal);

    }

}
