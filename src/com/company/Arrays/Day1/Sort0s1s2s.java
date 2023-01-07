package com.company.Arrays.Day1;

import java.util.Arrays;

public class Sort0s1s2s {

    public static void main(String[] args) {
        int[] arr1 = {2, 0, 2, 1, 1, 0};
        sort012(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    // sort -> nlogn TC

    // TC -> O(n)
    // SC -> O(1)
    public static void sort012(int[] arr) {
        int zeroS = 0;
        int oneS = 0;
        int twoS = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zeroS++;
            if (arr[i] == 1) oneS++;
            if (arr[i] == 2) twoS++;
        }
        for (int i = 0; i < zeroS; i++) arr[i] = 0;
        for (int i = zeroS; i < zeroS + oneS; i++) arr[i] = 1;
        for (int i = zeroS + oneS; i < arr.length; i++) arr[i] = 2;
    }
}
