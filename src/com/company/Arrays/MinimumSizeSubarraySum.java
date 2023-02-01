package com.company.Arrays;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
         int[] arr = {2,3,1,2,4,3};
         System.out.println(minSubArrayLen1(7,arr));
         System.out.println(minSubArrayLen2(7,arr));
    }

    // Brute Force
    // TC=O(N^2)
    // SC=O(1)
    public static int minSubArrayLen1(int k, int[] nums) {
        int min = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= k) {
                return 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= k) {
                    min = Math.min(min, j - i + 1);
                    //break here since adding further more elements will only increase length
                    break;
                }
            }
        }
        // in case no such combo exists return 0 else min.
        return min > nums.length ? 0 : min;
    }

    // Sliding Window
    // TC=O(N)
    // SC=O(1)
    public static int minSubArrayLen2(int k, int[] nums) {
        //hold answer
        int min = nums.length + 1;
        //hold sum till point
        int sum = 0;
        //start and end will be the boundary of window
        for (int start = 0, end = 0; end < nums.length;) {
            //consume elements in window till sum reaches k
            while (end < nums.length && sum < k) {
                sum += nums[end++];
            }
            //here we are sure that sum of window is k.
            //but it might be possible that last element which is included make sum very much more than k
            //hence we might need to remove elements from start to make it just greater than k.
            while (sum >= k) {
                sum -= nums[start++];
            }
            //here at this point we are sure we have end and start pointing to lowest length elements to make sum k.
            min = Math.min(min, end - start + 1);
        }
        // in case no such combo exists return 0 else min.
        return min > nums.length ? 0 : min;
    }


}
