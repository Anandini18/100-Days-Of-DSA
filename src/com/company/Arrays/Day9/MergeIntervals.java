package com.company.Arrays.Day9;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
           int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
           int[][] res = merge(arr);
           for (int i=0;i<res.length;i++){
               System.out.print(Arrays.toString(res[i]));
           }
    }

    // Time complexity - O(nlogn)
    // Space complexity - O(n)
    public static int[][] merge(int[][] intervals) {

        ArrayList<int[]>  ans = new ArrayList<>();
        if(intervals.length==0) return ans.toArray(new int[0][]);

        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0],b[0]));

        int[] curr = intervals[0];
        for(int i=1;i<intervals.length;i++){

            if(curr[1]<intervals[i][0]){
                ans.add(curr);
                curr=intervals[i];
            }
            else{
                curr[1]=Math.max(curr[1],intervals[i][1]);
            }
        }
        ans.add(curr);

        return ans.toArray(new int[0][]);

    }


}
