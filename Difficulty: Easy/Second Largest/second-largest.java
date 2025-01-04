//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        if (arr == null || arr.length < 2) {
            return -1; // Not enough elements to find second maximum
        }
    
        int fmax = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
    
        for (int num : arr) {
            if (num > fmax) {
                smax = fmax;
                fmax = num;
            } else if (num > smax && num != fmax) {
                smax = num;
            }
        }
    
        if (smax == Integer.MIN_VALUE) {
            return -1; // No second maximum found
        } else {
            return smax;
        }
    }
    
}