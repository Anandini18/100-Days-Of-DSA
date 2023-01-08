package com.company.Arrays.Day2;

import java.util.Arrays;

public class CyclicallyRotateArrayByK {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        rotateByOne(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        rotateByK(arr2, 703);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        rotateByK(arr3, 105);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {1, 2, 3, 4, 5, 6};
        rotateByK(arr4, 604);
        System.out.println(Arrays.toString(arr4));

    }

    // TC -> O(N)
    // SC -> O(1)
    // or, we can store last element somewhere, and shift 4-> last pos, 3 -> second last & at last, at 1st index, store 5
    public static void rotateByOne(int arr[]) {
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, i - 1);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // TC -> O((k%N)*N)
    // SC -> O(1)
    // array will be in the original position when rotated : 7,14,21...700 (multiple of no.of elements)
    public static void rotateByK(int arr[], int k) {
        k = k % arr.length;
        // now run algo of rotate by 1 , k (updated) times.
        for (int j = 0; j < k; j++) {
            for (int i = arr.length - 1; i > 0; i--) {
                swap(arr, i, i - 1);
            }
        }
    }


    // Using Extra Space

    // TC -> O(N)
    // SC -> O(N)
    public static void rotateExtraSpace(int[] arr, int k) {
        k = k % arr.length;
        int[] nums = new int[arr.length];
        int a = 0;
        for (int i = k; i < nums.length; i++) {
            nums[i] = arr[a];
            a++;
        }
        for (int i = 0; i < k; i++) {
            nums[i] = arr[a + 1];
        }

    }

    // Best Approach : Reversing The Sub-Array

    // TC -> O(N)
    // SC -> O(1)
    public static void rotateByReversing(int[] arr, int k) {
        k = k % arr.length;
        int n = arr.length - 1;
        reverse(arr, 0, n);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
