package com.company.Matrix;

public class SpecificPairMatrix {
    public static void main(String[] args) {

        int mat[][] = {
                         { 1, 2, -1, -4, -20 },
                         { -8, -3, 4, 2, 1 },
                         { 3, 8, 6, 1, 3 },
                         { -4, -1, 1, 7, -6 },
                         { 0, -4, 10, -5, 1 }
                       };
        System.out.println(findMaxValue1(mat));
    }

    // TC = O(N^4)
    // SC = O(1)
    public static int findMaxValue1(int mat[][])
    {
        int n=mat.length;
        int maxValue = Integer.MIN_VALUE;

        // Check all possible pairs of mat[a][b] & mat[c][d]
        for (int a = 0; a < n - 1; a++)
            for (int b = 0; b < n - 1; b++)
                for (int c = a + 1; c < n; c++)
                    for (int d = b + 1; d < n; d++)
                            maxValue = Math.max(maxValue,(mat[c][d] - mat[a][b]));

        return maxValue;
    }


}
