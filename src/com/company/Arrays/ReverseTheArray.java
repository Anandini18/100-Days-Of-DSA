package com.company.Arrays;

import java.util.Arrays;

public class ReverseTheArray {


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        int[] arr3 = {11, 22, 33, 44, 55};

        // calling funs
        System.out.println(Arrays.toString(revExtraSpace(arr1)));
        revBySwapping(arr2);
        System.out.println(Arrays.toString(arr2));
        revByRecursion(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));
    }

    // rev fun by using extra space

    // TC -> O(n)
    // SC -> O(n) -> creating new array of length 'n'
    public static int[] revExtraSpace(int[] arr) {
        int[] revArr = new int[arr.length];
        int n = arr.length;
        for (int i = 0; i < revArr.length; i++) {
            revArr[i] = arr[n - 1 - i];
        }
        return revArr;
    }

    // rev fun by swapping

    // TC -> O(n)
    // SC -> O(1)
    public static void revBySwapping(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    // rev fun using recursion

    // TC -> O(n/2) -> O(n) : as, we call reverse fun N/2 tyms & each call we swap the values which take O(1) time & we hv ignored (1/2).
    // SC -> O(N) : we recursively call to reverse fun N/2 tyms, means our stack size is N/2.

    public static void revByRecursion(int[] arr, int start, int end) { // arguments will go in future calls
        if (start > end) return; // break condition
        int n = arr.length;
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        revByRecursion(arr, start + 1, end - 1); // calling fun itself
    }


}
