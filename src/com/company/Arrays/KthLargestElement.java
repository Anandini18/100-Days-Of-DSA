package com.company.Arrays;

import java.util.Arrays;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(kthValue(arr1, k));

    }

    // TC -> O(NlogN)
    // SC -> O(1)
    public static int kthValue(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    // Using Heap
    // More Optimized Solution

}
