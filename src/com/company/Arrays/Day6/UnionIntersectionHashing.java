package com.company.Arrays.Day6;

import java.util.HashSet;

public class UnionIntersectionHashing {

    public static void main(String[] args) {
        int[] arr1={1,2,4,5,7,5,5};
        int[] arr2={9,5};
        System.out.println(UnionHashing(arr1,arr2));
        System.out.println(IntersectionHashing(arr1,arr2));
    }

    // Hashing method
    // TC -> O(m+n)
    // SC -> O(m+n)
    public static int UnionHashing(int[] arr1,int[] arr2){
        HashSet<Integer> unionSet = new HashSet<>();
        for(int i:arr1){
            unionSet.add(i);
        }
        for(int i: arr2){
            unionSet.add(i);
        }
        return unionSet.size();
    }

    // Hashing method
    // TC -> O(m+n)
    // SC -> O(m+n)
    public static int IntersectionHashing(int[] arr1,int[] arr2){
        int count=0;
        HashSet<Integer> intersection = new HashSet<>();
        for(int i:arr1){
            intersection.add(i);
        }
        for(int i: arr2){
            if(intersection.contains(i)){
                count++;
                // for duplicate elements
                intersection.remove(i);
            }
        }
        return count;
    }





}
