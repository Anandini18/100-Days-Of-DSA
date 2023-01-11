package com.company.Arrays.Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr={9,1,2,2,3,8,3,3,4,5,7,7,10,1,6,9};
        int[] arr2={1,2,3,4,4};
        System.out.println(duplicates(arr));
        System.out.println(duplicates2(arr));
        System.out.println(findDuplicate(arr2));
    }

    //TC -> O(n log n)
    // SC -> O(N)
    public static ArrayList<Integer> duplicates(int arr[]) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Arrays.sort(arr);
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]) {
                if(!res.contains(arr[i]))
                    res.add(arr[i]);
            }
        }
        if(res.isEmpty()) res.add(-1);
        return res;
    }

    //TC -> O(N^2)
    // SC -> O(N)
    public static ArrayList<Integer> duplicates2(int arr[]) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(j!=i && arr[i]==arr[j]) {
                    if(!res.contains(arr[i]))
                    {res.add(arr[i]);}
                    break;}
            }
        }
        if(res.isEmpty()) res.add(-1);
        Collections.sort(res);
        return res;
    }

    // TC -> O(N)
    // SC -> O(1)
    public static int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if(nums[index]<0) return index;
            nums[index]=-nums[index];
        }
        return -1;
    }


}
