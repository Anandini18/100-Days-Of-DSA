package com.company.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {};
    }

    /*
    Brute Force Approach :

    For each element in the array, we find the maximum level of water it can trap after the rain,
    which is equal to the minimum of maximum height of bars on both the sides minus its own height.

    Algorithm :

    1. Initialize ans=0.
    2. Iterate the array from left to right.
    3. Initialize left_max=0 & right_max=0.
    4. Iterate from the current element to the beginning of array updating.
    5. left_max=max(left_max,height[j]).
    6. Iterate from the current element to the end of array updating.
    7. right_max=max(right_max,height[j]).
    8. Add min(left_max,right_max)−height[i] to ans.

    */

    // Brute Force Approach
    // TC = O(N^2)
    // SC = O(1)
    public int trap1(int[] heights) {
        int ans = 0;
        int length = heights.length;

        for (int i = 0; i < length; i++) {

            int left = 0, right = 0;
            for (int j = i; j >= 0; j--) {
                left = Math.max(heights[j], left);
            }
            for (int k = i; k < length; k++) {
                right = Math.max(right, heights[k]);
            }

            ans = ans + Math.abs(Math.min(left, right) - heights[i]);
        }
        return ans;
    }

    /*
    Array PreProcessing :
      1. Find left maximum height & right maximum height of the bar .
      2. Calculate water level of every bar (water level = Min. of leftmax[i] , rightmax[i]) .
      3. Calculate trapped water (trapped water += water level - height[i](height of every bar)) .
     */

    // Array Preprocessing
    // TC = O(N)
    // SC = O(N)
    public int trap2(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[right.length - 1] = height[height.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += (Math.min(left[i], right[i]) - height[i]);
        }
        return ans;

    }

    /*
    Two pointer Approach:

      1. Get the left and right pointer.
      2. If the left pointer height value is smaller than the right pointer , increment the left pointer.
      3. Get the value in the variable and check the max of it.
      4. If it vice-versa, then decrement the right pointer.
      5. Keep adding the value to the answer.
      6. Return the Answer.
     */

    // Two-pointer Approach
    // TC = O(N)
    // SC = O(1)
    public int trap3(int[] height) {
        int leftMax = 0, rightMax = 0, ans = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax < height[left]) {
                    leftMax = height[left];
                }
                ans = ans + leftMax - height[left];
                left++;
            } else {
                if (rightMax < height[right]) {
                    rightMax = height[right];
                }
                ans = ans + rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
