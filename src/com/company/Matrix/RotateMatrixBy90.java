package com.company.Matrix;

import java.util.Arrays;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
         int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
         rotate(arr);
         for(int[] i : arr){
             System.out.println(Arrays.toString(i));
         }
    }

    // TC = O(N*N)
    // SC = O(1)
    public static void rotate(int[][] matrix) {
        // transpose the matrix
        transpose(matrix);
        // reverse every row
        reverse(matrix);
    }

    public static void transpose(int[][] matrix){
        for(int i = 0; i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    public static void reverse(int[][] matrix){
        for(int i = 0; i<matrix.length;i++){
            int left=0;
            int right = matrix[0].length-1;

            while(left<=right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }
    }
}
