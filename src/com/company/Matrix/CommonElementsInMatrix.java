package com.company.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElementsInMatrix {
    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                };
        commonElements(mat);
        commonElements2(mat, mat.length, mat[0].length);
    }


    // TC = O(NN*M)
    // SC = O(M)
    public static void commonElements(int[][] mat) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int col = 0; col < mat[0].length; col++) {
            map.put(mat[0][col], 1);
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (map.get(mat[i][j]) != null && map.get(mat[i][j]) == i) {
                    map.put(mat[i][j], i + 1);
                }
                if (i == mat.length - 1) {
                    if (map.get(mat[i][j]) != null && map.get(mat[i][j]) == mat.length)
                        System.out.println(mat[i][j]);
                }
            }
        }
    }

    // TC = O(N^3)
    // SC = O(1)

    public static void commonElements2(int Mat[][], int r, int c) {
        // pick one by one element of the first row and check if they are present in all rows.
        for (int firstRow = 0; firstRow < c; firstRow++) {
            // pick element
            int element = Mat[0][firstRow];
            // if duplicate then skip the element
            if (seen(Mat[0], element, firstRow)) continue;
            // variable for tracking rows.
            int count = 0;
            // if element is not present in anyone of the row then skip the element.
            int flag = 0;
            // traverse from 1st to last row
            for (int row = 1; row < r; row++) {
                for (int col = 0; col < c; col++) {
                    // if element is found then increment the counter
                    if (element == Mat[row][col]) {
                        count++;
                        // if present in last row and count is equal to row-1, then print it
                        if (row == r - 1 && count == r - 1)
                            System.out.println(element);
                            // if count is same as row then break to avoid adding duplicates
                        else if (row != r - 1 && count == row)
                            break;
                            // if element not present in the current row then set flag to 1,
                        else {
                            flag = 1;
                            break;
                        }
                    }
                }
                // break the outer loop and check for next element.
                if (flag == 1) break;
            }
        }
    }

    // function to check if there is any duplicate elements in the firstRow
    public static boolean seen(int arr[], int element, int end) {
        for (int i = 0; i < end; i++) {
            if (element == arr[i]) return true;
        }
        return false;
    }
}
