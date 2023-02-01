package com.company.Arrays;

public class MinSwapsKTogether {
    public static void main(String[] args) {

    }

    // Sliding Window
    // TC = O(N)
    // SC = O(1)
    public static int minSwap (int arr[], int k) {

        // for calculating window size
        int count=0;

        // bad no.s -> no.s which are not less than or equal to k.
        int bad=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k) count++;
        }
        for(int i=0;i<count;i++){
            if(arr[i]>k) bad++;
        }

        int ans=bad;
        for(int i=0,j=count;j<arr.length;i++,j++){
            if(arr[i]>k) bad--;
            if(arr[j]>k) bad++;
            ans=Math.min(ans,bad);
        }
        return ans;

    }
}
