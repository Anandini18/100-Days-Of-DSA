package com.company.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimizeTheHeights {
    public static void main(String[] args) {
        int[] arr1 = {8, 1, 5, 4, 7, 5, 7, 9, 4, 6};

        System.out.println(maxHeight1(arr1, 5));
        System.out.println(maxHeight2(arr1, 5));

    }

    // If resultant array can contain any -ve integers.
    // TC -> O(N * log(N)), Time is taken for sorting
    // SC -> O(1)
    public static int maxHeight1(int[] arr, int k) {
        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[arr.length - 1];
        int ans = b - a;

        for (int i = 1; i < arr.length; i++) {
            // Maximum element when we subtract k from whole array
            int max = Math.max(b - k, arr[i - 1] + k);
            // Minimum element when we add k to whole array
            int min = Math.min(a + k, arr[i] - k);
            int diff = max - min;
            ans = Math.min(diff, ans);
        }
        return ans;
    }

    // If resultant array cannot contain any -ve integers.

    public static int maxHeight2(int[] arr, int k) {
        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[arr.length - 1];
        int ans = b - a;
        for (int i = 1; i < arr.length; i++) {
            int max = Math.max(b - k, arr[i - 1] + k);
            int min = Math.min(a + k, arr[i] - k);
            if (min < 0) continue;
            int diff = max - min;
            ans = Math.min(diff, ans);
        }
        return ans;
    }
}






