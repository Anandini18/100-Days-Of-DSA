package com.company.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};

        merge(arr1, 3,arr2,3 );
        System.out.println(Arrays.toString(arr1));

        int[] arr5 = {1,2,3,0,0,0};
        int[] arr6 = {2,5,6};

        merge2(arr5, 3,arr6,3);
        System.out.println(Arrays.toString(arr5));

        int[] arr3 = {1,2,3};
        int[] arr4 = {2,5,6,67};
        System.out.println(merge3(arr3,arr4));

    }

    // Brute-Force
    // TC -> O(m+n log(m+n)) : sorting, else :
    // SC -> O(1)

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=0;
        for(int i=m;i<m+n;i++){
            nums1[i]=nums2[k];
            k++;
        }
        Arrays.sort(nums1);
    }

    // Optimized
    // TC -> O(m+n)
    // SC -> O(1)
    public static void merge2(int[] nums1, int m,int[]nums2,int n){
        int i=m-1;
        int j=n-1;
        int k=m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                k--;
                i--;
            }
            else{
                nums1[k]=nums2[j];
                j--;
                k--;
            }
        }
        while (i>=0){
            nums1[k--]=nums1[i--];
        }
        while (j>=0){
            nums1[k--]=nums2[j--];
        }


    }

    // using extra space
    // TC -> O(m+n)
    // SC -> O(m+n)

    public static ArrayList<Integer> merge3(int[] nums1, int[]nums2){
        int ptr1=0;
        int ptr2=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(ptr1<nums1.length && ptr2<nums2.length){

            if(nums1[ptr1]<nums2[ptr2]){
                list.add(nums1[ptr1]);
                ptr1++;
            }

            else{
                list.add(nums2[ptr2]);
                ptr2++;
            }
        }

        while(ptr1< nums1.length){
            list.add(nums1[ptr1]);
            ptr1++;
        }
        while(ptr2< nums2.length){
            list.add(nums2[ptr2]);
            ptr2++;
        }
        return list;
    }

}
