package com.company.Arrays;

public class JumpGame {
    public static void main(String[] args) {

        int[] arr={2,3,1,1,4};
        System.out.println(canJump(arr));
        System.out.println(jumps(arr));
    }

    // TC = O(N)
    // SC = O(1)
    public static boolean canJump(int[] nums) {
        int lastPos=nums.length-1;
        int n=nums.length-1;
        for(int i=n-1;i>=0;i--){

            if(i+nums[i]>=lastPos) lastPos=i;

        }
        return lastPos==0;
    }

    // TC = O(N)
    // SC = O(1)
    public static int jumps(int[] nums) {

        int steps=nums[0];
        int maxReach=nums[0];
        int jumps=1; // becoz we will take atleast one jump.

        if(nums[0]==0) return 0;
        if(nums.length<=1) return 0;

        for(int i=1;i<nums.length;i++){

            if(i==nums.length-1) return jumps;

            maxReach=Math.max(maxReach,i+nums[i]);
            steps--;
            if(steps==0){
                jumps++;
                steps=maxReach-i;
            }
        }
        return jumps;
    }
}
