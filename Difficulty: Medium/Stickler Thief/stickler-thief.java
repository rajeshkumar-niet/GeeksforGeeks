//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    
    // Tabulation DP : time 0.52
    public int findMaxSum(int arr[]) {
        if(arr.length <= 2){
            return Math.max(arr[0], arr[1]);
        }
        int[] dp = new int[arr.length + 2];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        
        for(int i = 2; i < arr.length; i++){
            int take = arr[i] + dp[i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[arr.length - 1];
    }
    
    // // Method 2 :  time takes 0.58 Memoization
    // static int recu(int idx, int[] arr, int[] dp){
    //     if(idx >= arr.length) return 0;
        
    //     if(dp[idx] != -1){
    //         return dp[idx];
    //     }
        
    //     int taken = arr[idx] + recu(idx+2, arr, dp);
    //     int notTaken = recu(idx+1, arr, dp);
        
    //     dp[idx] =  Math.max(taken, notTaken);
        
    //     return dp[idx];
        
    // }
    // // Function to find the maximum money the thief can get.
    // public int findMaxSum(int arr[]) {
    //     // Your code here
    //     if(arr.length <= 2){
    //         return Math.max(arr[0], arr[1]);
    //     }
    //     int[] dp = new int[arr.length + 2];
    //     Arrays.fill(dp, -1);
    //     return recu(0, arr, dp);
    // }
    
    
    
    // Method 1 :  TLE at 10/1115
    // static int recu(int idx, int[] arr){
    //     if(idx >= arr.length) return 0;
        
    //     int taken = arr[idx] + recu(idx+2, arr);
    //     int notTaken = recu(idx+1, arr);
        
    //     return Math.max(taken, notTaken);
        
    // }
    // // Function to find the maximum money the thief can get.
    // public int findMaxSum(int arr[]) {
    //     // Your code here
    //     return recu(0, arr);
    // }
}
