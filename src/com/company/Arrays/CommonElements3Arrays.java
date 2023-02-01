package com.company.Arrays;

import java.util.ArrayList;

public class CommonElements3Arrays {
    public static void main(String[] args) {
        int[] arr1={1, 5, 10, 20, 40, 80};
        int[] arr2={6, 7, 20, 80, 100};
        int[] arr3={3, 4, 15, 20, 30, 70, 80, 120};

        System.out.println(commonElements(arr1,arr2,arr3));
    }

    // TC -> O(n1+n2+n3)
    // SC -> O(1)
    public static ArrayList<Integer> commonElements(int A[], int B[], int C[])
    {
        ArrayList<Integer> list = new ArrayList<>();

        int a=0;
        int b=0;
        int c=0;

        while(a<A.length && b<B.length && c<C.length){

            if(A[a]<B[b]) a++;
            else if(A[a]>B[b]) b++;
            else{
                // For skipping Duplicate Elements
                if(a>0 && A[a]==A[a-1]){
                    a++;
                    continue;
                }

                // Checking common element in third array

                while(c<C.length && C[c]<B[b]) c++;
                if(c<C.length && C[c]==B[b]){
                    list.add(C[c]);
                }
                a++;
                b++;
            }}
        return list;
    }
}
