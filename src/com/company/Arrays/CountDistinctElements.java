package com.company.Arrays;

import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {
         int[] arr = {1,2,3,3,2,1};
         System.out.println(countElements(arr));
    }

    // Hashing Method
    // TC -> O(N)
    // SC -> O(N)
    public static int countElements(int[] arr){
        HashSet<Integer> res=new HashSet<Integer>();
        for(int i : arr){
            res.add(i);
        }
        // as, hashmap will include only the unique elements.
        // if we include, 1,2,2,3 in hash set then, it will only add -> 1,2,3
        System.out.println(res);
        return res.size();
    }


}
