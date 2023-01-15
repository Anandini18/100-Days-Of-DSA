package com.company.Arrays.Day8;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctElementInWindowK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 2, 3, 1};
        System.out.println(countDistinct(arr,4));
        System.out.println(countDistinct2(arr,4));
    }

    // Brute Force Solution
    // TC = O((N-k+1)*k^2)
    // SC = O(1)
    public static ArrayList<Integer> countDistinct(int A[], int k) {

        ArrayList<Integer> countArr = new ArrayList<>();

        for (int i = 0; i < A.length - k + 1; i++) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                boolean distinct_Element = true;
                for (int m = i; m < j; m++) {
                    if (A[j] == A[m]) {
                        distinct_Element = false;
                        break;
                    }
                }
                if (distinct_Element == true) count++;
            }
            countArr.add(count);
        }
        return countArr;
    }


    // Using HashMap
    // TC = O(N)
    // SC = O(N)
    public static ArrayList<Integer> countDistinct2(int A[], int k)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        // Traverse the first window and store count
        // of every element in hash map
        for(int i=0;i<k;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }
        arr.add(map.size());

        for(int i=k;i<A.length;i++){
            // Remove first element of previous window
            // If there was only one occurrence
            if(map.get(A[i-k])==1) map.remove(A[i-k]);

                // else reduce count of the removed element
            else map.put(A[i-k],map.get(A[i-k])-1);

            // Add new element of current window
            // If this element appears first time,
            // set its count as 1,
            map.put(A[i],map.getOrDefault(A[i],0)+1);

            arr.add(map.size());
        }
        return arr;
    }


}
