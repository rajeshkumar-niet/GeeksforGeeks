//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    
    public static int minChar(String s) {
        
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "$" + reversed;

        // Compute the LPS array
        int[] lps = computeLPS(combined);

        // The number of characters to add is the difference between
        // the string length and the length of the longest palindromic prefix
        return s.length() - lps[lps.length - 1];
    }

    private static int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
    
    
    
    // This code (below) passes 1111 test cases out of 1112 but at last it TLE
    
    // public static boolean isPalindromme(String str, int start, int end) {
    //     while (start < end) {
    //         if (str.charAt(start) != str.charAt(end)) {
    //             return false;
    //         }
    //         start++;
    //         end--;
    //     }
    //     return true;
    // }
    // public static int minChar(String s) {
    //     // Write your code here
    //     int result = s.length() - 1;

    //     for (int i = s.length() - 1; i >= 0; i--) {
    //         if (isPalindromme(s, 0, i)) {
    //             return s.length() - 1 - i;
    //         }
    //     }
    //     return result;
    // }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }
    }
}
// } Driver Code Ends