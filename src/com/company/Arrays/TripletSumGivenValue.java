package com.company.Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class TripletSumGivenValue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 6};
        System.out.println(find3Numbers(arr,10));
        System.out.println(find3Numbers2(arr,10));
        System.out.println(find3Numbers3(arr,10));
    }

    // Brute Force
    // TC = O(N^3)
    // SC = O(1)
    public static boolean find3Numbers(int A[], int X) {
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 1; j < A.length - 1; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    if (A[i] + A[j] + A[k] == X) {
                        System.out.println("[ " + A[i] + " " + A[j] + " " + A[k] + " ]");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Sorting
    // TC = O(N^2)
    // SC = O(1)
    public static boolean find3Numbers2(int A[], int X) {

        Arrays.sort(A);
        int left, right;

        for (int i = 0; i < A.length - 2; i++) {
            left = i + 1;
            right = A.length - 1;

            while (left < right) {
                if (A[i] + A[left] + A[right] == X) {
                    System.out.println("[ " + A[i] + " " + A[left] + " " + A[right] + " ]");
                    return true;
                } else if (A[i] + A[left] + A[right] < X) left++;
                else right--;
            }
        }
        return false;
    }

    // Using HashMap
    // TC = O(N^2)
    // SC = O(N)
    public static boolean find3Numbers3(int A[], int sum) {
        for (int i = 0; i < A.length - 2; i++) {
            HashSet<Integer> set = new HashSet<>();
            int curSum = sum - A[i];
            for (int j = i + 1; j < A.length; j++) {
                if (set.contains(curSum - A[j])) {
                    System.out.println("[ " + A[i] + " " + A[j] + " " + (curSum - A[j]) + " ]");
                    return true;
                }
                set.add(A[j]);
            }
        }
        return false;
    }


}
