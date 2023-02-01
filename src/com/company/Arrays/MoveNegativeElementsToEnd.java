package com.company.Arrays;

import java.util.Arrays;

public class MoveNegativeElementsToEnd {

    // Constraint : Relative order of non-negative elements as well as negative elements must be maintained.

    public static void main(String[] args) {
        int[] arr1 = {-11, -1, 3, 24, -7, -5, 11, -6};

        System.out.println(Arrays.toString(MovingUsingNewArray(arr1)));

        WithoutUsingExtraSpace(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    // TC -> O(N)
    // SC -> O(N)
    public static int[] MovingUsingNewArray(int[] arr) {
        int[] nums = new int[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                nums[k] = arr[i];
                k++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                nums[k] = arr[i];
                k++;
            }
        }
        return nums;
    }

    // TC -> O(N^2)
    // SC -> O(1)
    public static void WithoutUsingExtraSpace(int arr[]) {
        int k = arr.length - 1;
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 0) {
                for (int j = i; j < k; j++) {
                    swap(arr, j, j + 1);
                }
                k--;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
