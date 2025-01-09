//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans =
                ob.lenOfLongestSubarr(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int lenOfLongestSubarr(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If the current prefixSum equals k, update maxLength
            if (prefixSum == k) {
                maxLength = i + 1;
            }

            // Check if prefixSum - k exists in the map
            if (map.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum - k));
            }

            // Store the prefix sum in the map if not already stored
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
    
    
    
    
    // Brute Force approach 
    // public int lenOfLongestSubarr(int[] arr, int k) {
    //     // code here
    //     int maxLength = 0;


    //     for (int i = 0; i < arr.length; i++) {
    //         int sum = 0;

    //         // Iterate over all subarrays starting from index i
    //         for (int j = i; j < arr.length; j++) {
    //             sum += arr[j];

    //             // Check if the current sum equals k
    //             if (sum == k) {
    //                 maxLength = Math.max(maxLength, j - i + 1);
    //             }
    //         }
    //     }

    //     return maxLength;
    // }
}
