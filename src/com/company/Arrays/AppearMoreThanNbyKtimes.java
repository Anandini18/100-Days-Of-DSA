package com.company.Arrays;

import java.util.*;

public class AppearMoreThanNbyKtimes {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
        System.out.println(moreThanNdK(arr, 4));
        System.out.println(moreThanNdK2(arr, 4));

        int[] arr2 = {2, 1, 3, 3, 3};
        System.out.println(majorityElement(arr2));
        System.out.println(majorityElement2(arr2));

        moreThanNdKMoore(arr,arr.length,4);
    }

    // Brute Force
    // TC = O(N^2)
    // SC = O(1)
    public static ArrayList<Integer> moreThanNdK(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int x = arr.length / k;

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = 0; j < arr.length; j++) {
                if (j != i && arr[j] == arr[i]) count++;
            }
            if (count > x) if (!list.contains(arr[i])) list.add(arr[i]);
        }
        return list;
    }

    // Using HashMap
    // TC = O(N)
    // SC = O(N)
    public static ArrayList<Integer> moreThanNdK2(int[] arr, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);

        for (int i = 1; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else map.put(arr[i], 1);
        }

        for (Map.Entry i : map.entrySet()) {

            Integer temp = (Integer) i.getValue();
            if (temp > (arr.length / k)) list.add((Integer) i.getKey());
        }
        return list;
    }


    // By Sorting
    // TC = O(N logN)
    // SC = O(1)

    // Works only when there is only 1 element is in majority
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
    Moore's Voting Algorithm

    2 steps :

    1. We find the element which is majority in Array.
    2. We check whether the count of majority element is greater than n/k or not.

     */

    // TC = O(N)
    // SC = O(1)
    public static int majorityElement2(int[] nums) {

        // step : 1
        int count = 1;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[res] == nums[i]) count++;
            else count--;

            if (count == 0) {
                res = i;
                count++;
            }
        }

        // step : 2
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[res] == nums[i]) count++;
        }
        if (count <= (nums.length / 2)) return -1;
        else return nums[res];

    }

    /* Moore Voting Algorithm with more than 1 element in the majority.

    There can be at max k – 1 elements present in the array
    which appears more than n/k times so their will be k – 1 candidates.
    When we encounter an element which is one of our candidates then increment the count else decrement the count.

    1. Create a temporary array of size (k – 1) to store elements and
       their counts (The output elements are going to be among these k-1 elements).
    2. Traverse through the input array and update temp[]
       (add/remove an element or increase/decrease count) for every traversed element.
       The array temp[] stores potential (k-1) candidates at every step.
    3. Iterate through final (k-1) potential candidates (stored in temp[]),
       for every element, check if it actually has counted of more than n/k.

     */

    // TC = O(N * K): Checking for each element of the array(size N) in the candidate array of size K
    // SC = O(K)    : Space required to store the candidates.

    static class eleCount {
        int e; // Element
        int c; // Count
    };
    public static void moreThanNdKMoore(int arr[], int n, int k) {
        // k must be greater than
        // 1 to get some output
        if (k < 2)
            return;

		/* Step 1: Create a temporary
		array (contains element
		and count) of size k-1.
		Initialize count of all
		elements as 0 */
        eleCount[] temp = new eleCount[k - 1];
        for (int i = 0; i < k - 1; i++)
            temp[i] = new eleCount();
        for (int i = 0; i < k - 1; i++) {
            temp[i].c = 0;
        }

		/* Step 2: Process all
		elements of input array */
        for (int i = 0; i < n; i++) {
            int j;

			/* If arr[i] is already present in
			the element count array,
			then increment its count
			*/
            for (j = 0; j < k - 1; j++) {
                if (temp[j].e == arr[i]) {
                    temp[j].c += 1;
                    break;
                }
            }

            /* If arr[i] is not present in temp[] */
            if (j == k - 1) {
                int l;

				/* If there is position available
				in temp[], then place arr[i] in
				the first available position and
				set count as 1*/
                for (l = 0; l < k - 1; l++) {
                    if (temp[l].c == 0) {
                        temp[l].e = arr[i];
                        temp[l].c = 1;
                        break;
                    }
                }

				/* If all the position in the
				temp[] are filled, then decrease
				count of every element by 1 */
                if (l == k - 1)
                    for (l = 0; l < k - 1; l++)
                        temp[l].c -= 1;
            }
        }

        /*Step 3: Check actual counts of
         * potential candidates in temp[]*/
        for (int i = 0; i < k - 1; i++) {

            // Calculate actual count of elements
            int ac = 0; // actual count
            for (int j = 0; j < n; j++)
                if (arr[j] == temp[i].e)
                    ac++;

            // If actual count is more than n/k,
            // then print it
            if (ac > n / k)
                System.out.print("Number:" + temp[i].e + " Count:" + ac + "\n");
        }
    }
}
