package com.company.Matrix;

import java.util.Arrays;

public class SortMatrix {

    public static void main(String[] args) {
          int[][] mat = { {10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50}, };

          sortedMatrix(mat.length,mat);

    }

    // TC = O(N^2 log(N^2))
    // SC = O(N^2)
    public static int[][] sortedMatrix(int N, int Mat[][]) {
        int[] ans = new int[N*N];
        int k=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                ans[k]=Mat[i][j];
                k++;
            }
        }
        k=0;
        Arrays.sort(ans);
        while(k<ans.length){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    Mat[i][j]=ans[k];
                    k++;
                }
            }
        }
        for(int[] arr : Mat){
            System.out.println(Arrays.toString(arr));
        }
        return Mat;
    }

    // Optimised solution : Using Heap
}
