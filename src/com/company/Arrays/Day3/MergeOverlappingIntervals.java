package com.company.Arrays.Day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr2 = {{1, 4}, {4, 5}};

        merge(arr1);
        System.out.println();
        merge(arr2);

    }

    // TC:O(n logn)
    // SC:O(1)
    public static int[][] merge(int[][] intervals) {

        //sorting the given interval array based on starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res = new ArrayList<>();

        //defining start and end point
        int low = intervals[0][0];
        int high = intervals[0][1];

        //we will iterate through the 2d array intervals so in each iteration we will get a row[1D array] as i
        for (int i = 1; i < intervals.length; i++) {

            //check if end point of 1st pair if greater than the starting point of the 2nd pair or not,
            // basically we check it's in overlapping condition or not
            if (intervals[i][0] <= high) {
                if (high < intervals[i][1])
                    high = intervals[i][1];
            }

            //otherwise add it in the list
            else {
                res.add(new int[]{low, high});
                low = intervals[i][0];
                high = intervals[i][1];
            }
        }
        res.add(new int[]{low, high});
        for (int i = 0; i < res.size(); i++) {
            System.out.print(Arrays.toString(res.get(i)));
        }

        return res.toArray(new int[0][]);
    }
}

