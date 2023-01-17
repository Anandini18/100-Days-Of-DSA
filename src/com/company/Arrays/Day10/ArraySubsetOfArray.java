package com.company.Arrays.Day10;

import java.util.Arrays;
import java.util.HashSet;

public class ArraySubsetOfArray {
    public static void main(String[] args) {
        int[] arr1={8, 4, 5, 3, 1, 7, 9};
        int[] arr2={5, 1, 3, 7, 9};
        System.out.println(isSubset1(arr1,arr2));
        System.out.println(isSubset3(arr1,arr2));
    }

    // Brute Force Approach
    // TC = O(m*n)
    // SC = O(1)
    public static boolean isSubset1(int[] arr1, int[] arr2){
        int m=arr1.length;
        int n= arr2.length;
        int i = 0;
        int j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) if (arr2[i] == arr1[j]) break;

            if (j == m) return false;
        }
        return true;
    }

    // Using HashSet
    // TC = O((m+n)*logm) : logm for contains fun of hashset.
    // SC = O(m)
    public static boolean isSubset3(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i: arr1) set.add(i);

        for(int i: arr2) if(!set.contains(i)) return false;
        return true;
    }
}
