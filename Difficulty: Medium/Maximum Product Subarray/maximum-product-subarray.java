//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        int currMin = arr[0];
        int currMax = arr[0];
        int prodMax = arr[0];
        
        for(int i =1; i < arr.length; i++){
            int temp = Math.max(arr[i], Math.max(arr[i]*currMin, arr[i]*currMax));
            currMin =  Math.min(arr[i], Math.min(arr[i]*currMin, arr[i]*currMax));
            currMax = temp;
            
            prodMax = Math.max(currMax, prodMax);
        }
        return prodMax;
    }
}