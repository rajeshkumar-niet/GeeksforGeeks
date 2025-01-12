//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to count number of ways to reach the nth stair.
    // DP bottom up time 0.22
    int countWays(int n) {
        // your code here
        if(n <= 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
    
    // static int count(int n, int[] dp){
    //     if(n <= 2) return n;
    //     if(dp[n] != 0)
    //         return dp[n];
        
    //     dp[n] = count(n-1, dp)+ count(n-2, dp);
    //     return dp[n];
    // }
    // // DP top-down time 0.24
    // int countWays(int n) {
    //     // your code here
    //     if(n <= 2) return n;
    //     int[] dp = new int[n+1];
    //     return count(n, dp);
    // }
    
    // Recursion time 0.26
    // int countWays(int n) {
    //     // your code here
    //     if(n <= 2) return n;
    //     return countWays(n-1) + countWays(n-2);
    // }
}
