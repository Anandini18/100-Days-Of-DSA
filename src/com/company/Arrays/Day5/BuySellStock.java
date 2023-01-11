package com.company.Arrays.Day5;

import java.util.Arrays;

public class BuySellStock {
    public static void main(String[] args) {
        int[] arr1={7,1,5,3,6,4};

        System.out.println(maxProfit1(arr1));
        System.out.println(maxProfit2(arr1));
        System.out.println(maxProfit2(arr1));
    }

    // TC -> O(N^2)
    // SC -> O(1)
    public static int maxProfit1(int[] prices) {
        int profit=0;
        int max=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                profit=prices[i]-prices[j];
                if(profit<max) max=profit;
            }
            profit=0;
        }
        return max*(-1);
    }

    // TC -> O(N)
    // SC -> O(N)
    public static int maxProfit2(int[] arr) {
        int[] maxProfit=new int[arr.length];
        int max=arr[arr.length-1];
        int profit=0;
        maxProfit[maxProfit.length-1]=max;
        for(int i=arr.length-2;i>=0;i--){
            maxProfit[i]=Math.max(arr[i],max);
            if(max<arr[i]) max=arr[i];
        }
        for(int i=0;i<maxProfit.length;i++){
            profit=Math.min(profit,arr[i]-maxProfit[i]);
        }
        return profit*-1;
    }

    // TC -> O(N)
    // SC -> O(1)
    public static int maxProfit3(int[] arr) {
        int minBuy=arr[0];
        int maxProfit=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<minBuy) minBuy=arr[i];
            else maxProfit=Math.max(maxProfit,arr[i]-minBuy);
        }
        return maxProfit;
    }
}
