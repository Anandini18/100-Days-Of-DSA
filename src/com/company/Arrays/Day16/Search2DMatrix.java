package com.company.Arrays.Day16;

public class Search2DMatrix {
    public static void main(String[] args) {

        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr,3));
        System.out.println(searchMatrix2(arr,8));
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
        int col = matrix[0].length-1;

        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]>target) col--;
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
        public static boolean searchMatrix2(int[][] matrix, int target) {
            int row = 0;
            int col = matrix[0].length-1;

            // Finding the potential row
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][0]<=target && matrix[i][col]>=target){
                    row = i;
                }
            }

            // Finding the potential column
            int start = 0;
            int end = matrix[0].length-1;

            while(start<=end){
                int mid = start + (end-start)/2;
                if(matrix[row][mid]==target) return true;
                else if(matrix[row][mid]<target) start=mid+1;
                else end=mid-1;
            }
            return false;

        }
    }

