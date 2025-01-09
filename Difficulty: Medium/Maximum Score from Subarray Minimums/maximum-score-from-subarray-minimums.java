//{ Driver Code Starts
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String token : tokens) {
                nums.add(Integer.parseInt(token));
            }
            int[] arr = new int[nums.size()];
            int idx = 0;
            for (int i : nums) arr[idx++] = i;
            Solution solution = new Solution();
            System.out.println(solution.pairWithMaxSum(arr));

            System.out.println("~");
        }

        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(int arr[]) {
        // Your code goes here
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
    
        // Iterate through all adjacent pairs
        for (int i = 0; i < n - 1; i++) {
            // Smallest and second smallest are arr[i] and arr[i+1]
            int min1 = Math.min(arr[i], arr[i + 1]);
            int min2 = Math.max(arr[i], arr[i + 1]);
    
            // Update maxSum
            maxSum = Math.max(maxSum, min1 + min2);
        }
    
        return maxSum;
    }
}