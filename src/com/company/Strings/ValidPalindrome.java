package com.company.Strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome2(s));
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j))){
                j--;
                continue;
            }
            if(!(s.charAt(i) == s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        // convert Strign s to lowerCase with regex
        String tempString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // Reverse the tempString
        String rev = new StringBuffer(tempString).reverse().toString();
        // check tempString to rev String
        return tempString.equals(rev);
    }
}
