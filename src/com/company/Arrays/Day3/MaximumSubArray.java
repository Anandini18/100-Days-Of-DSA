package com.company.Arrays.Day3;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(MaxSubArray(arr1));
        System.out.println(MaxSubArrayRunningSum(arr1));
        System.out.println(KadaneAlgo(arr1));


    }

    // No. of Sub Arrays = N*(N+1)/2

    // TC -> O(N^3)
    // SC -> O(1)
    public static int MaxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + nums[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    // TC -> O(N^2)
    // SC -> O(1)
    public static int MaxSubArrayRunningSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    // TC -> O(N)
    // SC -> O(1)
    public static int KadaneAlgo(int[] nums) {
        int currentSum = nums[0];
        int bestSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentSum >= 0) currentSum = currentSum + nums[i];
            else currentSum = nums[i];
            if (currentSum > bestSum) bestSum = currentSum;
        }
        return bestSum;
    }

}


