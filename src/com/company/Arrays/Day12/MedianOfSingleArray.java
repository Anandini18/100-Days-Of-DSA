package com.company.Arrays.Day12;

import java.util.Arrays;

public class MedianOfSingleArray {
    public static void main(String[] args) {
        int[] arr = {56, 67, 30, 79};
        int[] arr2= {90 ,100 ,78 ,89 ,67};
        System.out.println(find_median(arr));
        System.out.println(find_median(arr2));

    }

    // Median of a single array
    public static int find_median(int[] v) {
        Arrays.sort(v);
        if (v.length % 2 != 0) return v[(v.length - 1) / 2];
        return (v[(v.length - 1) / 2] + v[v.length / 2]) / 2;
    }

    // Using Extra Space
    // TC = O(m+n)
    // SC = O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int k =0;
        while(k<nums1.length+nums2.length && i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]) {
                temp[k]=nums1[i];
                i++;
            }
            else {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<nums1.length){
            temp[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            temp[k] = nums2[j];
            j++;
            k++;
        }

        if (temp.length % 2 != 0) return temp[(temp.length - 1) / 2];
        double d = (temp[(temp.length - 1) / 2] + temp[temp.length / 2])/2.00;
        return  d;
    }


}
