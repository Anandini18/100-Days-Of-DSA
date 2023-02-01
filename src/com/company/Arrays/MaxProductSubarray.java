package com.company.Arrays;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr1 = {-2, 3, -4};
        System.out.println(maxProduct(arr1));
    }

    // Kadane's Algorithm
    // TC = O(n)
    // SC = O(1)
    public static int maxProduct(int[] nums) {
        int maxPro = nums[0];
        int minPro = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // swap minPro & maxPro
                // as if multiplied by a -ve no.
                // min num becomes max, & max become min. (sign change)
                int temp = minPro;
                minPro = maxPro;
                maxPro = temp;
            }

            maxPro = Math.max(maxPro * nums[i], nums[i]);
            minPro = Math.min(minPro * nums[i], nums[i]);

            ans = Math.max(ans, maxPro);

        }
        return ans;
    }
}
