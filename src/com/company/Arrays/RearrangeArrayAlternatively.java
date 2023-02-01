package com.company.Arrays;

import java.util.Arrays;

public class RearrangeArrayAlternatively {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        long[] arr2 = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(rearrange1(arr1, arr1.length)));
        rearrange2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    // Using Extra Space
    // TC = O(N)
    // SC = O(N)

    static int[] rearrange1(int a[], int n) {
        // initializing output array of size-n
        int output[] = new int[n];

        // initializing the pointers
        int i = 0, j = n - 1, k = 0;

        // inserting element from input array until i<= j
        while (i <= j) {
            // inserting the current greatest element and moving pointers of input and output array.
            output[k++] = a[j--];

            // inserting the current smallest element and moving pointers of input and output array
            output[k++] = a[i++];

        }
        return output;
    }
    // Without using extra space
    // TC = O(N)
    // SC = O(1)

    public static void rearrange2(long arr[]) {

        int maxIndex = arr.length - 1;
        int minIndex = 0;

        // so that all the elements
        // when divided by max -> gives the same no as,
        // x%y = x always if y<x
        long max = arr[arr.length - 1] + 1;

        for (int i = 0; i < arr.length; i++) {

            if (i % 2 == 0) {
                arr[i] = (arr[maxIndex] % max) * max + arr[i];
                maxIndex--;
            } else {
                arr[i] = (arr[minIndex] % max) * max + arr[i];
                minIndex++;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= max;
        }

    }
}
