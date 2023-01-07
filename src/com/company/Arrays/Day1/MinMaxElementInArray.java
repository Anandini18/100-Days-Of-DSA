package com.company.Arrays.Day1;

import java.util.Arrays;

public class MinMaxElementInArray {
    public static void main(String[] args) {
        int[] arr1 = {21, 345, 234, 21, 56789};

        System.out.println(Arrays.toString(minMax(arr1)));
    }

    // TC -> O(N)
    // SC -> O(1)
    public static int[] minMax(int[] arr) {

        if (arr == null || arr.length == 0) return new int[]{}; // Edge Case

        int[] nums = new int[2];
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        nums[0] = min;
        nums[1] = max;
        return nums;
    }
}
