package com.company.Arrays.Day13;

public class BuyingSellingShareTwice {
    public static void main(String[] args) {
             int[] arr={7, 1, 5, 3, 6, 4};
             System.out.println(maxProfit(arr));
             System.out.println(maxProfit2(arr));
    }

    // TC = O(N)
    // SC = O(1)
    public static int maxProfit(int[] prices) //basic approach
    {
        int maximumProfit = 0;
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > prices[i - 1])
                maximumProfit += prices[i] - prices[i - 1];
        }
        return maximumProfit;
    }

    // TC = O(N)
    // SC = O(1)
    public static int maxProfit2(int[] prices) //peak valley approach
    {
        int i=0;
        int peak=prices[0];
        int valley=prices[0];
        int maxProfit=0;
        while(i<prices.length-1)
        {
            while(i<prices.length-1 && prices[i]>=prices[i+1])
                i++;
            valley=prices[i];
            while(i<prices.length-1 && prices[i+1]>=prices[i])
                i++;//post fix use
            peak=prices[i];
            maxProfit+=peak-valley;
        }
        return maxProfit;
    }
}
