package com.company.Arrays;

public class MinSwapsPalindrome {

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(minMovesToMakePalindrome(s));
        System.out.println(minMovesToMakePalindrome2(s));
    }

    /*
    Intially, steps = 0.
            * 	We will use 2 index pointers initially - "l" as Left and "r" as right.
            * 	'l' will move to right and 'r' will move to left in each iteration. ( l -->    <-- r )
            * 	Each time, we want to check whether characters at "l" & "r" are equal.
            * 	If yes, then we dont need to do anything as both characters on left & right boundry already are palindrome.
                Hence, we do l++ & r--.
            * 	Else, we assign a index pointer "k" at same index as "r".
                It's purpose is to find kth index of character matching with (equal to) character at lth index.
                So,  keep moving this pointer towards left until we find the character.
                We did this in code using method findKthIndexMatchingwithLthIndex().
            * 	If character not found, k index will reach at index of l.  (k==l).
            * 	Else, if found, now we want to bring this character to the index of "r". Hence keep swapping while(k < r).
            * 	Repeat above steps.

     */

    /*

    EXAMPLE AND DRY _ RUN


    "a   l   e   t   e   l   t"
     l                       r                  // strArr[l] != strArr[r].  initiate index k = r
                             k                  // loop through k using method findKthIndexMatchingwithLthIndex(), until strArr[l] == strArr[k]

     "a   l   e   t   e   l   t"
      l                       r
      k                                         // k reached to index l but did not find any index of k which is equal to strArr[l]
                                                // So, now swap strArr[l] & strArr[l+1]   => now steps = 1

     "l   a   e   t   e   l   t"
      l                       r                 // strArr[l] != strArr[r].  initiate index k = r
                              k                 // loop through k using method findKthIndexMatchingwithLthIndex(), until strArr[l] == strArr[k]

     "l   a   e   t   e   l   t"
      l                       r
                          k                     // reached k, where strArr[l] == strArr[k]
                                                // Here k != l, so using while loop, keep swapping element at k and k+1, until k < r.
												// Here "steps" will be updated to 2 i.e steps now = 2

      "l   a   e   t   e   t   l"
       l                       r
                               k                // now do l++ and r--

      "l   a   e   t   e   t   l"
           l               r
                           k

Similarly, keep following above steps or below code, below will be rest of the dry run.

       "l   a   e   t   e   t   l"              // strArr[l] != strArr[r]
            l               r
                            k

       "l   a   e   t   e   t   l"
            l               r
            k                                   // k reached to index l but did not find any index of k which is equal to str[l]
                                                // So, now swap strArr[l] & strArr[l+1]  => now steps = 3

       "l   e   a   t   e   t   l"              // strArr[l] != strArr[r]
            l               r
                            k

       "l   e   a   t   e   t   l"
            l               r
                        k                       // reached k, where strArr[l] == strArr[k]
                                                // Here k != l, so using while loop, keep swapping element at k and k+1, until k < r.
												Here "steps" will be updated to 4 i.e steps now = 4

       "l   e   a   t   t   e   l"
            l               r
                            k

       "l   e   a   t   t   e   l"
                l       r
                        k

       "l   e   a   t   t   e   l"
                l       r
                k                               // k reached to index l but did not find any index of k which is equal to str[l]
                                                // So, now swap strArr[l] & strArr[l+1]   => now steps = 5

       "l   e   t   a   t   e   l"              //  We have got palindrome by now
                l       r
                        k

     */


    // Two Pointer Approach
    // TC = O(N^2)
    // SC = O(N)
    public static int minMovesToMakePalindrome(String s) {
        int len = s.length();
        char[] strArr = s.toCharArray();
        int steps = 0;

        // use two pointers l for left and r for right.
        int l = 0, r = len - 1;

        while (l < r) {
            // Both characters are equal. so keep going futher.
            if (strArr[l] == strArr[r]) {
                l++;
                r--;
            } else {
                // Both characters are not equal.
                int k = r;
                // loop through k, until char at index k = char at index l
                k = findKthIndexMatchingwithLthIndex(strArr, l, k);

                if (k == l) {
                    // we did not find any char at k = char at index l
                    swap(strArr, l);
                    steps++;
                } else {
                    while (k < r) {
                        swap(strArr, k);
                        steps++;
                        k++;
                    }
                    l++;
                    r--;
                }
            }// end of else

        }   // end of while
        System.out.println("palindrome: " + String.valueOf(strArr));
        return steps;

    }


    public static int findKthIndexMatchingwithLthIndex(char[] strArr, int l, int k) {
        while (k > l) {
            if (strArr[k] == strArr[l]) {
                return k;
            }
            k--;
        }
        return k;
    }

    public static void swap(char[] strArr, int l) {
        if (l + 1 < strArr.length) {
            char tempCh = strArr[l];
            strArr[l] = strArr[l + 1];
            strArr[l + 1] = tempCh;
        }
    }

    public static int minMovesToMakePalindrome2(String s) {

        int ans = 0;

        int start = 0, end = s.length() - 1;

        char ch[] = s.toCharArray();

        while (start < end) {

            int r = end;

            if (ch[start] == ch[end]) {
                start++;
                end--;
                continue;
            }

            while (ch[start] != ch[r]) {
                r--;
            }// aabb l is pointing at 0 th index while r is pointing to b which is not equal to a so r-- by doing this we are searching whether any a is present there other than the one which l is pointing

            if (start == r) // means no a is present other than first index
            {
                //swap them

                swap(ch, r, r + 1);
                ans++;

            } else {
                while (r < end) {
                    swap(ch, r, r + 1);
                    ans++;
                    r++;
                }
            }
        }
        return ans;
    }

    private static void swap(char ch[], int i, int j) {
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }

}
