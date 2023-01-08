package com.company.Arrays.Day2;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionIntersectionOf2Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 4, 7, 81, 45};
        int[] arr2 = {0, 33, 1, 1, 4, 45, 90};

        System.out.println(UnionCount(arr1, arr2));
        System.out.println(Union(arr1, arr2));
        System.out.println(Intersection(arr1, arr2));
    }

    // 2-pointer approach

    // TC -> O(m+n) -> If the array is given sorted.
    // (Use  " union.get(union.size()-1)!=nums1[a] " instead of " !union.contains(nums1[a]) " ) for O(m+n) complexity as,
    // list.contains() requires O(n) time to perform.
    // SC -> O(1)
    public static ArrayList<Integer> Union(int[] nums1, int[] nums2) {
        ArrayList<Integer> union = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int a = 0;
        int b = 0;

        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] == nums2[b]) {
                if (!union.contains(nums1[a])) union.add(nums1[a]);
                a++;
                b++;
            } else if (nums1[a] < nums2[b]) {
                if (!union.contains(nums1[a])) union.add(nums1[a]);
                a++;
            } else {
                if (!union.contains(nums2[b])) union.add(nums2[b]);
                b++;
            }
        }

        if (a == nums1.length) {
            while (b < nums2.length) {
                if (!union.contains(nums2[b])) union.add(nums2[b]);
                b++;
            }
        }

        if (b == nums2.length) {
            while (a < nums1.length) {
                if (!union.contains(nums1[a])) union.add(nums1[a]);
                a++;
            }
        }
        return union;
    }

    // TC -> O((m+n)log(m+n))
    // SC -> O(m+n)
    public static int UnionCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int count = 1;
        int[] list = new int[m + n];
        for (int i = 0; i < n; i++) {
            list[i] = nums1[i];
        }

        int k = 0;
        for (int j = n; j < m + n; j++) {

            list[j] = nums2[k];
            k++;
        }

        Arrays.sort(list);

        for (int i = 1; i < list.length; i++) {
            while (list[i] == list[i - 1]) i++;
            count++;
        }
        return count;
    }

    public static ArrayList<Integer> Intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> intersection = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int a = 0;
        int b = 0;

        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] == nums2[b]) {
                if (!intersection.contains(nums1[a])) intersection.add(nums1[a]);
                a++;
                b++;
            } else if (nums1[a] < nums2[b]) {
                a++;
            } else {
                b++;
            }
        }

        return intersection;
    }

}
