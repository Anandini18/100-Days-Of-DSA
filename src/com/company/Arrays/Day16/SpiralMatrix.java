package com.company.Arrays.Day16;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    // TC = O(m*n)
    // SC = O(1)
    public static List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> arr = new ArrayList<>();

        int total = matrix.length*matrix[0].length;

        int colStart = 0;
        int colEnd = matrix[0].length-1;
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int count=0;

        while(count<total){

            //  top wall
            for(int i=colStart;i<=colEnd && count<total;i++){
                arr.add(matrix[rowStart][i]);
                count++;
            }
            rowStart++;

            // right wall
            for(int i=rowStart;i<=rowEnd && count<total;i++){
                arr.add(matrix[i][colEnd]);
                count++;
            }
            colEnd--;

            // bottom wall
            for(int i=colEnd;i>=colStart && count<total;i--){
                arr.add(matrix[rowEnd][i]);
                count++;
            }
            rowEnd--;

            // left wall
            for(int i=rowEnd;i>=rowStart && count<total;i--){
                arr.add(matrix[i][colStart]);
                count++;
            }
            colStart++;
        }
        return arr;
    }
}
