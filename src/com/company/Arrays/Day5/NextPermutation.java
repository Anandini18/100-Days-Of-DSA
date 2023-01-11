package com.company.Arrays.Day5;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr={1,2,3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }



    // TC -> O(N)
    // SC -> O(1)
    public static void nextPermutation(int[] arr) {

        if (arr.length == 1) return;

        int k1 = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                k1 = i;
                break;
            }
        }
        if (k1 < 0) revByRecursion(arr, 0, arr.length - 1);
        else {
            int k2 = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[k1] < arr[i]) {
                    k2 = i;
                    break;
                }
            }
            swap(arr, k1, k2);
            revByRecursion(arr, k1 + 1, arr.length - 1);
        }
    }

    // swap fun
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // reverse fun
    public static void revByRecursion(int[] arr, int start, int end) {
        if (start > end) return;
        int n = arr.length;
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        revByRecursion(arr, start + 1, end - 1);
    }


}
