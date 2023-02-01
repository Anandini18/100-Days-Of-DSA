package com.company.Arrays;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,5,8,9,10};
        int[] arr2 = {4,6,7,12,15,45,67,90,100};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }

    // Binary Search
    // Work with all types of array sizes : (a.length) >,<,= (b.length)
    // TC = O(log(m+n))
    // SC = O(1)
    public static double findMedianSortedArrays(int[] a, int[] b) {

        if(a.length>b.length){
            int[] temp = a;
            a=b;
            b=temp;
        }

        int low = 0;
        int high=a.length;
        int total = a.length+b.length;

        while(low<=high){
            int aleft=(low+high)/2;
            int bleft=(total+1)/2-aleft;

            // al -> a[left]
            // alm1 -> a[left-1]
            int alm1=(aleft==0) ? Integer.MIN_VALUE : a[aleft-1];
            int al = (aleft==a.length) ? Integer.MAX_VALUE : a[aleft];
            int blm1=(bleft==0) ? Integer.MIN_VALUE : b[bleft-1];
            int bl = (bleft==b.length)? Integer.MAX_VALUE : b[bleft];

            // when valid seggregation is found.
            if(alm1<=bl && blm1<=al){
                double median = 0.0;

                if(total%2==0){
                    int lmax=Math.max(alm1,blm1);
                    int rmin = Math.min(al,bl);
                    median =(lmax+rmin)/2.0;
                }
                else{
                    int lmax=Math.max(alm1,blm1);
                    median=lmax;
                }
                return median;
            }
            else if(alm1 >bl){
                // take more elements from the left part of array b
                high = aleft-1;
            }
            else if(blm1>al){
                // take more elements from the left part of array a
                low = aleft+1;
            }
        }
        return 0.0;
    }
}
