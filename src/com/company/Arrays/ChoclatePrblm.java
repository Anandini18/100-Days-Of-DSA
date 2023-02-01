package com.company.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChoclatePrblm {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>() {
            {
                add(3);
                add(4);
                add(1);
                add(9);
                add(56);
                add(7);
                add(9);
                add(12);
            }
        };

        System.out.println(findMinDiff(arr,arr.size(),5));
    }

    // Sorting
    // TC = O(N logN)
    // SC = O(1)
    public static long findMinDiff(ArrayList<Integer> a,int n,int m)
    {
        Collections.sort(a);

        long ans=Long.MAX_VALUE;
        for(int i=0;i<=a.size()-m;i++){
            long min=a.get(i);
            // it is necessary to cast 'm' (long) to int
            // as in the indexes of array or arraylist, there can only be int type values.
            long max=a.get(i+(int)m-1);
            long diff = max-min;
            if(diff<ans) ans=diff;
        }
        return ans;
    }
}
