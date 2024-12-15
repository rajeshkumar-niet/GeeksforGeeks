//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int kthElement(int a[], int b[], int k) {
        int ai = 0; // Pointer for array `a`
        int bi = 0; // Pointer for array `b`

        // Iterate until k elements are merged
        for (int i = 0; i < k - 1; i++) {
            if (ai < a.length && (bi >= b.length || a[ai] <= b[bi])) {
                ai++; // Increment pointer for `a`
            } else {
                bi++; // Increment pointer for `b`
            }
        }

        // Determine the k-th element
        if (ai < a.length && (bi >= b.length || a[ai] <= b[bi])) {
            return a[ai];
        } else {
            return b[bi];
        }
    }
}
