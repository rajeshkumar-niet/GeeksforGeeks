//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {
    int getMinDiff(int[] arr, int k) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        int n = arr.length;

        // Step 2: Calculate the initial difference
        int minDiff = arr[n - 1] - arr[0];

        // Step 3: Iterate to minimize the difference
        for (int i = 0; i < n - 1; i++) {
            int smallest = Math.min(arr[0] + k, arr[i + 1] - k);
            int largest = Math.max(arr[n - 1] - k, arr[i] + k);
            if (smallest >= 0) { // Ensure no negative heights
                minDiff = Math.min(minDiff, largest - smallest);
            }
        }
        return minDiff;
    }
}

