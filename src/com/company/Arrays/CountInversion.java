package com.company.Arrays;

public class CountInversion {
    public static void main(String[] args) {

        long[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr,5));
    }

    // TC -> O(N^2)
    // SC -> O(1)
    public static long inversionCount(long arr[], long N)
    {
        long count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i>j && arr[i]<arr[j]) {
                    count++;
                    System.out.println(arr[j]+","+arr[i]);
                }

            }
        }
        return count;
    }
}
