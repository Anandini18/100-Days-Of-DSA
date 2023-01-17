package com.company.Arrays.Day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutive {
    public static void main(String[] args) {
          int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive1(arr));
        System.out.println(longestConsecutive2(arr));
        System.out.println(longestConsecutive3(arr));
    }

    // Sorting + Without using Extra Space
    // TC = O(N logN)
    // SC = O(1)
    public static int longestConsecutive1(int[] nums) {

        if(nums.length==0) return 0;
        if(nums.length==1) return 1;

        Arrays.sort(nums);
        int count=0;
        int temp=0;

        for(int i=0;i<nums.length;i++){

            while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
            if(i<nums.length-1 && nums[i]==nums[i+1]-1){
                temp++;
            }

            else{
                temp=0;
            }
            count=Math.max(count,temp);
        }
        return count+1;
    }

    // Sorting + Without using Extra Space
    // TC = O(N logN)
    // SC = O(1)
    public static int longestConsecutive2(int[] nums) {

        if(nums.length==0) return 0;

        Arrays.sort(nums);

        ArrayList<Integer> unique = new ArrayList<>();
        unique.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            if(i>0 && nums[i]!=nums[i-1]) unique.add(nums[i]);
        }

        int count=0;
        int temp=0;
        for(int i=1;i<unique.size();i++){
            if(unique.get(i)==unique.get(i-1)+1) temp++;
            else temp=0;
            count=Math.max(temp,count);
        }
        return count+1;
    }

    // Using HashMap
    // TC = O(N)
    // SC = O(N)
    public static int longestConsecutive3(int[] nums) {

        if(nums.length==0) return 0;
        if(nums.length==1) return 1;

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) set.add(nums[i]);

        int ans=0;

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1)) continue;
            else{
                int count=0;
                int k=nums[i];
                while(set.contains(k)) {
                    count++;
                    k++;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }

}
