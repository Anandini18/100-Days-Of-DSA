package com.company.Arrays.Day8;

import java.util.Arrays;

public class RearrangeBySign {
    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray1(arr)));
        System.out.println(Arrays.toString(rearrangeArray2(arr)));
    }

    // Using Extra Space
    // TC = O(N)
    // SC = O(N)
    public static int[] rearrangeArray1(int[] nums) {
        int[] arr = new int[nums.length];
        int start = 0;
        int end = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                arr[start] = nums[i];
                start += 2;
            }
            if (nums[i] < 0) {
                arr[end] = nums[i];
                end += 2;
            }

        }
        return arr;
    }

    // Without Using Extra Space
    // TC = O(N)
    // SC = O(1)

    public static int[] rearrangeArray2(int[] nums) {
        int pos = 0;
        int neg = 0;
        int i = 0;
        int[] res = new int[nums.length];
        while (pos < nums.length && neg < nums.length) {
            if (nums[pos] > 0 && nums[neg] < 0) {
                res[i] = nums[pos];
                i++;
                pos++;
                res[i] = nums[neg];
                i++;
                neg++;
            } else if (nums[pos] > 0 && nums[neg] > 0) {
                neg++;
            } else if (nums[pos] < 0 && nums[neg] > 0) {
                pos++;
                neg++;
            } else {
                pos++;
            }
        }
        return res;
    }
}

