package com.company.Matrix;

import java.util.Arrays;

public class MedianOfMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 4}, {2, 5, 6}, {7, 8, 9}};
        System.out.println(median(matrix, matrix.length, matrix[0].length));
        System.out.println(median2(matrix, matrix.length, matrix[0].length));
    }

    // Without using Extra Space

    // TC = O(32*R*log(C))
    // In while loop of Binary Search -> it will take log(Max I/p) , Max I/p = 2000 (given) => log(2000) = 32 time.
    // In while loop -> there is a for loop which runs for every row -> takes 32*R time.
    // In for loop -> Arrays.binarySearch() is applied on columns -> so it will take 32*R*log(C) time.
    // SC = O(1)
    public static int median(int matrix[][], int R, int C) {

        // find max (high) & min (low) element

        // Note :
        // Min element will always be in the 1st column of matrix.
        // Max element will always be in the last column of matrix.

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for (int i = 0; i < R; i++) {
            if (matrix[i][0] < low) low = matrix[i][0];
            if (matrix[i][C - 1] > high) high = matrix[i][C - 1];
        }

        // index of the median or no. of element <=median
        int desired = (R * C + 1) / 2;


        // Why not low <=high ? -> becoz, we'll take high = mid & not mid-1.
        // It will give TLE if we do low<=high
        while (low < high) {
            int mid = low - (low - high) / 2;

            // count the no of elements that are <= mid in the whole matrix.
            int place = 0;

            // count the no. of elements that are <=mid in particular row.
            int get = 0;

            // get & place will be different for all the mid values.
            // hence initialized befor the for loop.

            // This for loop runs for each row & check how many no.s are there <=mid in row & matrix
            // & update get & place .

            for (int i = 0; i < R; i++) {

                // find mid in each row & update the no of elements <=mid of that row in get.
                // Arrays.BS will return the index if mid is present in the row
                // else it will return the -ve of the (insertion index+1) of the mid.
                // E.g. in arr = [1,20,3] if we do Arrays.BS(arr[0],4)
                // then, 4 is not present hence it will return -(1+1) = -2.

                get = Arrays.binarySearch(matrix[i], mid);

                // if mid is not present in the row .
                if (get < 0) get = Math.abs(get) - 1;
                    // -1 becoz of the +1 extra added in -(insertion index +1).

                    // else if mid is present in the row.
                else {
                    // while duplicates are there in the row -> increase the get value.
                    while (get < matrix[i].length && matrix[i][get] == mid) get += 1;
                }


                // add the get value in place to get the count of all no.s <= current mid in matrix.
                place = place + get;

            }

            if (place < desired) low = mid + 1;
            else high = mid;
        }
        // return low becoz when low become equals to high -> that's what our ans is !
        return low;
    }

    // By Using Extra Space

    // TC = O(M*N log(M*N))
    // SC = O(M*N)
    public static int median2(int[][] arr, int row, int col) {
        int[] median = new int[row * col];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                median[index] = arr[i][j];
                index++;
            }
        }
        return median[(row * col) / 2];
    }

}

