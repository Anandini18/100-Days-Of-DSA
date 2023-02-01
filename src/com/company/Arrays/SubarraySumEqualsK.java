package com.company.Arrays;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {

        int[] arr1={0,0,0,0,0,0,0};
        int[] arr2={1,2,3};

        System.out.println(subarraySum(arr1,0));
        System.out.println(subarraySum(arr2,3));

    }

    /*

    While iterating through the array if we can store the prefixSum at each index in a HashMap and at the same time,
    check if a prefixSum exists for the current (runningSum-k).
    we'll use use a HashMap to compute and store the prefix sums as Keys and the corresponding frequencies as Values.

    We'll run through the example step by step -

    Input:
    nums = [3,9,-2,4,1,-7]
    k = 5


    Step1:
    nums = [3,9,-2,4,1,-7]
            ^
    count = 0
    sum = 3
    map = [3:1]
    k = 5

    # 1 (i.e., runningSum-k, 3-5=-2) not found in map
    # add the curr sum 3 in map

    Step2:
    nums = [3,9,-2,4,1,-7]
            ^
    count = 0
    sum = 12
    map = [3:1, 12:1]

    # 0 (12-5) not found in map
    # add the curr sum 12 in map

    Step3:
    nums = [3,9,-2,4,1,-7]
            ^
    count = 0
    sum = 10
    map = [3:1, 12:1, 10:1]

    # 7 (10-5) not found in map
    # add the curr sum 10 in map

    Step4:
    nums = [3,9,-2,4,1,-7]
            ^
    count = 0
    sum = 14
    map = [3:1, 12:1, 10:1, 14:1]

    # 4 (14-5) not found in map.
    # add the curr sum 14 in map

    Step5:
    nums = [3,9,-2,4,1,-7]
            ^
    count = 1
    sum = 15
    map = [3:1, 12:1, 10:1, 14:1 , 15:1]

    # 5 (15-5) found in map . Increment the count
	#add cur sum 15 in map

    Step 6:
    nums = [3,9,-2,4,1,-7]
            ^
    count = 2
    sum = 8
    map = [3:1, 12:1, 10:1, 14:1 , 15:1,8:1]

    # 6 (8-5) found in map . Increment the count
    #add cur sum 8 in map
*/

    // TC -> O(N)
    // SC -> O(N)
    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int curSum=0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            curSum+=nums[i];

            if(curSum==k){
                count++;
            }

            if(map.containsKey(curSum-k)){
                // get the frequency of the (curSum-k) & add it to the count.
                count+=map.get(curSum-k);
            }

            // map.getOrDefault(curSum,0) -> If in the map , curSum is found,
            // then, assign that value to it, else assign '0' as specified.
            map.put(curSum,map.getOrDefault(curSum,0)+1);

        }
        return count;
    }



}
