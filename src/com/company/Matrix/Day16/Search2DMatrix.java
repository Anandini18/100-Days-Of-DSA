package com.company.Matrix.Day16;

import java.util.Arrays;

public class Search2DMatrix {
    public static void main(String[] args) {

        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(arr, 3));

        int row = findPotentialRow(arr, 10);
        System.out.println(Arrays.toString(binarySearch(arr, 10, row)));
    }

    // Taking top left corner as the starting point.
    // if whole array is sorted & last element of each row is less than the 1st element of next row.

    /*
        10 20 30 40
        50 55 70 80
        91 92 92 94
     */

    // TC = O(m+n)
    // SC = O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    // 2 level binary search
    // Can be used in a sorted array
    // Can be used when only row wise elements or column wise elements are sorted.
    // Not necessary that last element of each row is less than the 1st element of next row.

        /*
           10 20 30 40
           39 55 70 80
           11 20 92 94 -> elements are only sorted row wise and not column wise.
         */

    // TC = O(log m + log n) -> log(m*n)
    // SC = O(1)
    // function to find the potential row
    // potential row -> the row in which target can be found.
    public static int findPotentialRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int lastElement = matrix.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][lastElement]) {
                return mid;
            } else if (matrix[mid][0] <= target && matrix[mid][lastElement] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // function for finding the target in the potential row.
    // using the binary search.
    public static int[] binarySearch(int[][] matrix, int target, int row) {
        int start = 0;
        int end = matrix[row].length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            } else if (matrix[row][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}

