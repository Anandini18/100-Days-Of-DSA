package com.company.Arrays.Day7;

import java.util.ArrayList;

public class LargeNoFactorialArray {
    public static void main(String[] args) {
       int n = 10;
        System.out.println(factorial(n));
    }

    // TC = O(N^2)
    // SC = O(1)
    public static ArrayList<Integer> factorial(int n) {
        // declare an arraylist
        ArrayList<Integer> arr =new ArrayList<>();

        // size -> no. of digits of the product
        // carry -> No. / 10
        int size=1,carry=0;

        // Adding 1 at 0th index
        arr.add(0,1);

        // variable to start loop
        int val = 2;
        while(val<=n){

            // Traverse arrayList from right to left
            for(int i=size-1;i>=0;i--){

                // Update value in arrayList
                int temp=arr.get(i)*val+carry;

                // Store the last digit at index & add remaining to carry
                arr.set(i,temp%10);

                // Update carry
                carry=temp/10;
            }

            // Insert carry digit by digit to the beginning of the ArrayList
            while(carry!=0){
                arr.add(0,carry%10);
                carry=carry/10;
                size++;
            }
            val++;
        }

        return arr;
    }

}
