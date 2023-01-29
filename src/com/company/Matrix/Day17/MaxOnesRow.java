package com.company.Matrix.Day17;

public class MaxOnesRow {
    public static void main(String[] args) {

        int[][] mat = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 1, 1, 1}};
        System.out.println(rowWithMax1s(mat, mat.length, mat[0].length));
        System.out.println(rowWithMaxOnes(mat, mat.length, mat[0].length));
    }

    // TC = O(N log(M))
    // SC = O(1)

    public static int rowWithMax1s(int arr[][], int n, int m) {
        // maximum no of 1's
        int omax = 0;

        // rows with max no. of 1's
        int rowNo = 0;

        for (int i = 0; i < arr.length; i++) {
            int coir = binarySearch(arr, i);
            if (coir > omax) {
                omax = coir;
                rowNo = i;
            }
            if (omax == 0) rowNo = -1;
        }
        return rowNo;
    }

    // finding the max no of 1's in every row using binary search

    public static int binarySearch(int[][] arr, int i) {
        int low = 0;
        int high = arr[0].length - 1;
        int first1index = arr[0].length;

        while (low <= high) {
            int mid = low - (low - high) / 2;
            if (arr[i][mid] == 1) {
                first1index = mid; // this may be our 1st occurence of 1
                high = mid - 1;
            } else low = mid + 1;
        }

        int count = arr[0].length - first1index;
        return count;
    }

    /*
       1. The idea is to start from the top-right corner.
       2. If the current cell has value 1, then continue moving left until we find 0 and update the values.
       3. If the current cell has value 0, then continue moving downward until we come across 1.
       4. Finally, return the index of the row with the maximum number of 1s.
     */


    // TC = O(M+N)
    // SC = O(1)
    public static int rowWithMaxOnes(int arr[][], int n, int m) {

        int ansRow = -1;
        int j = m - 1;

        for (int i = 0; i < n && j >= 0; i++) {
            while (j >= 0) {
                if (arr[i][j] == 1) {
                    j--;
                    ansRow = i;
                } else break;
            }
        }
        return ansRow;

    }

    // Brute Force
    // TC = O(M*N)
    // SC=O(1)
    public static int findRowIndex(int[][] mat) {
        // base case
        if (mat == null || mat.length == 0) {
            return 0;
        }

        // stores row number with maximum index
        int row = -1;

        // `(i, j)` stores the current row and column index

        // start from the top-rightmost cell of the matrix
        int i = 0, j = mat[0].length - 1;

        while (i <= mat.length - 1 && j >= 0) {
            // move left if the current cell has value 1
            if (mat[i][j] == 1) {
                j--;
                row = i;    // update row number
            }
            // otherwise, move down
            else {
                i++;
            }
        }
        return row + 1;
    }


}
