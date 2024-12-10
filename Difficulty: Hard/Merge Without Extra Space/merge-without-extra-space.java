//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int[] a, int[] b) {
        int i = 0, j = 0;
        
        // Step 1: Iterate through a and b
        while (i < a.length && j < b.length) {
            // If a[i] is greater than b[j], swap them
            if (a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                
                // Step 2: After swapping, we need to sort b
                int curr = b[j];
                int k = j + 1;
                
                // Step 3: Shift elements of b to the right to place the current element in correct position
                while (k < b.length && b[k] < curr) {
                    b[k - 1] = b[k];
                    k++;
                }
                b[k - 1] = curr;  // Place current element at its correct position
            }
            
            // Move to the next element in a after the swap
            i++;
        }
    // At the end of the process, a will have the smaller elements, and b will have the larger elements.
    }

}
