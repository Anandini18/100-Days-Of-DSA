package com.company.Arrays.Day13;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreePartioningOfArray {
    public static void main(String[] args) {

        // order is maintained
        // for a single pivot
        int[] arr = {9, 12, 5, 10, 14, 3, 10};
        System.out.println(Arrays.toString(pivotArray(arr, 10)));

        // order is not maintained
        // for start & end pts.
        int[] arr2 = {6 ,22, 68, 5, 14, 62, 55, 27, 60, 45, 3, 3, 7, 85};
        threeWayPartition(arr2,22,64);
        System.out.println(Arrays.toString(arr2));


    }

    // Only 1 pivot
    // TC = O(N)
    // SC = O(N)
    public static int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int count = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[k] = nums[i];
                k++;
            }
            if (nums[i] == pivot) count++;
        }
        while (count > 0) {
            res[k] = pivot;
            count--;
            k++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                res[k] = nums[i];
                k++;
            }
        }
        return res;
    }

    // Dutch flag algorithm
    // TC = O(N)
    // SC = O(1)
    public static void threeWayPartition(int arr[], int a, int b) {
        int l = 0, r = arr.length - 1;
        int i = 0;
        while (i <= r) {
            if (arr[i] < a) {
                int temp = arr[i];
                arr[i] = arr[l];
                arr[l] = temp;
                l++;
                i++;
            } else if (arr[i] > b) {
                int temp = arr[i];
                arr[i] = arr[r];
                arr[r] = temp;
                r--;
            } else
                i++;
        }
    }
}
