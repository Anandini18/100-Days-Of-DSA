package com.company.Arrays;

import java.util.Arrays;

public class PairsOfGivenSum {
    public static void main(String[] args) {
        int[] arr={1, 5, 7, 1};

        System.out.println(getPairsCount1(arr,6));
    }

    // TC -> O(N^2)
    // SC -> O(1)
    public static int getPairsCount1(int[] arr,int k) {
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(i<arr.length-1 && arr[i]+arr[j]==k) {
                    count++;
                    System.out.println(Arrays.toString(new int[]{arr[i],arr[j]}));
                }
            }
        }
        return count;
    }

    // TC -> O(N)
    // Using Hashing
}
